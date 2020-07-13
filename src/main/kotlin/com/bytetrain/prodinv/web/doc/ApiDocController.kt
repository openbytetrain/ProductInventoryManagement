package com.bytetrain.prodinv.web.doc

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import java.util.*
import javax.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping(value = ["/v2/api-docs"])
class ApiDocController(@Qualifier("webApplicationContext") private val resourceLoader: ResourceLoader) {

    @GetMapping(produces = ["text/plain"])
    fun getApiDocs(request: HttpServletRequest, @RequestHeader headers: Map<String, String>): ResponseEntity<Any> {
        val resource: Resource = this.resourceLoader.getResource("classpath:/swagger/api.json")
        return if (resource.exists()) {
            val uriComponents = UriComponentsBuilder.fromHttpRequest(ServletServerHttpRequest(request))
                .build()
            val hostForCaller = "${uriComponents.host}:${uriComponents.port}"
            val mapper = ObjectMapper()
            val apiDocNode: ObjectNode = mapper.readTree(resource.inputStream) as ObjectNode
            apiDocNode.put("host", hostForCaller)
            apiDocNode.put("basePath", "/api")
            val modifiedPaths: MutableMap<String, JsonNode> = LinkedHashMap()
            val paths = apiDocNode.get("paths") as ObjectNode
            paths.fields().forEach { field ->
                modifiedPaths.put("/api${field.key}", field.value)
            }
            paths.removeAll()
            paths.setAll<JsonNode>(modifiedPaths)
            apiDocNode.toPrettyString()
            ResponseEntity.ok().body(apiDocNode.toPrettyString())
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}

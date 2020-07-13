package com.bytetrain.prodinv.config

import io.github.jhipster.config.JHipsterConstants
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile(JHipsterConstants.SPRING_PROFILE_SWAGGER)
class OpenApiConfiguration

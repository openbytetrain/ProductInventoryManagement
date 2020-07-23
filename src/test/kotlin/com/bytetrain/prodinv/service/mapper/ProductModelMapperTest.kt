import com.bytetrain.prodinv.service.mapper.*
import org.junit.jupiter.api.BeforeEach

class ProductMapperTest {

    private lateinit var productModelMapper: ProductModelMapper

    @BeforeEach
    fun setUp() {
        productModelMapper = ProductModelMapperImpl()
    }
}

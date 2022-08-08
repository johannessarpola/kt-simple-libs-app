import fi.johannes.lib.hash.HashLib
import fi.johannes.lib.strings.StringLib
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.util.*

fun main() {
    println("Testing libs!")

    val str = "String to MD5 with Lib"
    val md5 = HashLib.md5(str)
    println("$str ---")
    println(md5.b64())
    assert(Base64.getDecoder().decode(md5.b64()).isNotEmpty())

    val str2 = "String to be reversed"
    val rstr2 = StringLib.reverse(str2)
    println("$str2 ---")
    println(rstr2)
    assert(str2.reversed().equals(rstr2))

    val str3 = "Fox Fox Fox"
    val str3_2 = "Fox"
    val cnt = StringLib.count(str3, str3_2)
    println("$str3 count $str3_2 ---")
    println(cnt)
    assert(cnt == 3)

    val addr = "http://www.apache.org/"
    val request = HttpGet(addr)
    val httpClient: HttpClient = HttpClientBuilder.create().build()
    val statuscode = httpClient.execute(request).statusLine.statusCode
    println("$addr GET ---")
    println("Response code $statuscode")
    assert(statuscode == 200)

}
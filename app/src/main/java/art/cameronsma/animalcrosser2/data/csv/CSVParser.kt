package art.cameronsma.animalcrosser2.data.csv

import java.io.InputStream

// Takes in input stream and outputs it as a list
interface CSVParser<T> {
    suspend fun parse(stream: InputStream): List<T>
}
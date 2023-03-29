package kr.co.bullets.didemoreview

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize: Int) {

    @Provides
    fun providesMemoryCard(): MemoryCard {
        Log.i("MYTAG", "Size of the momory is $memorySize")
        return MemoryCard()
    }
}
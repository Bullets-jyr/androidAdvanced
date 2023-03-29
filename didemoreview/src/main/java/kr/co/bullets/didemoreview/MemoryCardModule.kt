package kr.co.bullets.didemoreview

import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule {

    @Provides
    fun providesMemoryCard(): MemoryCard {
        return MemoryCard()
    }
}
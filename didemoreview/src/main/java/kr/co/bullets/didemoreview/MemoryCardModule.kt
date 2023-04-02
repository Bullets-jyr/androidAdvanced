package kr.co.bullets.didemoreview

import android.util.Log
import dagger.Module
import dagger.Provides

// Now I am creating a module class for this dependency.
// To make this a dagger module we need to annotate it with module annotation.
@Module
class MemoryCardModule(val memorySize: Int) {

    // Now I am creating a provider function with the Return type of MemoryCard.
    // And We need to annotate this provider function with @provides annotation. We should always annotate provider functions with @provides annotation.
    // Otherwise dagger will not recognize it as a provider function. Marking a function with this annotation tells dagger, that this function provides an object of the return data type.
    // This module class has only one provider function. But a module can have more than one provider functions.
    @Provides
    fun providesMemoryCard(): MemoryCard {
        Log.i("MYTAG", "Size of the momory is $memorySize")
        return MemoryCard()
    }
}
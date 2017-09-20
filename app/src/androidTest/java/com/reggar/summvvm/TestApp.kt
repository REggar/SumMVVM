package com.reggar.summvvm

class TestApp : App() {
    override fun injectDependencies() {
        // Dependencies could be swapped here, but its not needed.
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }
}
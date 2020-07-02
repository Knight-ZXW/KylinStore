package com.kylin.store

/**
 * Interface for fetching and store data form persister
 * @param <Key> unique identifier for data
 * @param <Raw> data type
 */
interface Persister<Key, Raw> : DiskRead<Key, Raw>, DiskWrite<Key, Raw> {
    /**
     * @param key to use to get data from persister
     *
     * If data is not available implementer needs to
     *  either return null or throw an exception
     */
    override suspend fun read(key: Key): Raw?

    fun  syncRead(key: Key): Raw?

    /**
     * @param key to use to store data to persister
     * @param raw raw string to be stored
     */
    override suspend fun write(key: Key, raw: Raw): Boolean

    fun  syncWrite(key: Key, raw: Raw): Boolean

}
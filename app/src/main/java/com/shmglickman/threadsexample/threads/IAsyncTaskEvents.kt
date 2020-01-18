package com.shmglickman.threadsexample.threads

interface IAsyncTaskEvents {

    fun createAsyncTask()
    fun startAsyncTask()
    fun cancelAsyncTask()
    fun onPreExecute()
    fun onPostExecute()
    fun onProgressUpdate(num: Int)
    fun onCancel()
}

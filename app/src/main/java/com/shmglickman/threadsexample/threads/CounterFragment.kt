package com.shmglickman.threadsexample.threads

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.shmglickman.threadsexample.R
import kotlinx.android.synthetic.main.fragment_threads.*


class CounterFragment : Fragment(), View.OnClickListener {

    companion object {
        const val FRAGMENT_TYPE: String = "fragment_type"
    }

    private var callbackListener: IAsyncTaskEvents? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_threads, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        When you access btnAsyncCreate, it calls for getView().findViewById(R.id.btn_K).
//        The problem is that you are accessing it too soon. getView() returns null
//        getView() returns null in onCreateView, So we doing it in the onViewCreated method

        btnAsyncCreate.setOnClickListener(this)
        btnAsyncStart.setOnClickListener(this)
        btnAsyncCancel.setOnClickListener(this)

        //UNPACK OUR DATA FROM OUR BUNDLE
        this.arguments?.getString(FRAGMENT_TYPE)?.let {
            fullscreen_content?.text = it
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IAsyncTaskEvents) {
            callbackListener = context
        }

    }

    override fun onDetach() {
        super.onDetach()
        callbackListener = null
    }


    override fun onClick(v: View) {
        callbackListener?.let {
            if (isAdded) {
                when (v.id) {
                    R.id.btnAsyncCreate -> it.createAsyncTask()
                    R.id.btnAsyncStart -> it.startAsyncTask()
                    R.id.btnAsyncCancel -> it.cancelAsyncTask()
                }
            }
        }
    }

    fun updateFragmentText(text: String) {
        fullscreen_content.text = text
    }

}

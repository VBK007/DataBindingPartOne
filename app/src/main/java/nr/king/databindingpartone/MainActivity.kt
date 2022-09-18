package nr.king.databindingpartone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import nr.king.databindingpartone.adapter.DatabindingRecylerViewAdapter
import nr.king.databindingpartone.databinding.ActivityMainBinding
import nr.king.databindingpartone.model.DatabindingRecylerModel

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var recylerViewAdapter: DatabindingRecylerViewAdapter
    lateinit var arrayList:ArrayList<DatabindingRecylerModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.apply {
            showProgressBar = true
         setUi()
         Handler().postDelayed({
             getAllArrayList()
         },4000)
        }
    }

    private fun setUi() {
        activityMainBinding.apply {


        }
    }

    private fun getAllArrayList() {
        arrayList = ArrayList()
        arrayList.add(
            DatabindingRecylerModel(
            imageUrl = "https://images.news18.com/ibnlive/uploads/2022/08/virat-kohli-ap.jpg",
            likeCount = "4K",
            isLiked = true,
            userName = "Virat Kohli"
        )
        )

        arrayList.add(DatabindingRecylerModel(
            imageUrl = "https://i.ytimg.com/vi/D0STjbmtMjY/maxresdefault.jpg",
            likeCount = "100",
            isLiked = false,
            userName = "The Rock"
        ))


        arrayList.add(DatabindingRecylerModel(
            imageUrl = "https://hips.hearstapps.com/hbz.h-cdn.co/assets/16/10/1457919704-gettyimages-480667731.jpg",
            likeCount = "1M",
            isLiked = false,
            userName = "BrainShow"
        ))

        arrayList.add(DatabindingRecylerModel(
            imageUrl = "https://nordvpn.com/wp-content/uploads/android-vs-ios-bg.png",
            likeCount = "22M",
            isLiked = true,
            userName = "MarkWeins"
        ))

        arrayList.add(DatabindingRecylerModel(
            imageUrl = "https://assets.xboxservices.com/assets/39/09/3909c985-d854-4681-854d-2f89562086f1.jpg?n=PUBG_GLP-Page-Hero-1084_1920x1080_02.jpg",
            likeCount = "2",
            isLiked = false,
            userName = "CodePlays-Tamil"
        ))

        arrayList.add(DatabindingRecylerModel(
            imageUrl = "https://img.etimg.com/thumb/msid-92489173,width-650,imgsize-119796,,resizemode-4,quality-100/disney-johnny-depp-jack-sparrow.jpg\n",
            likeCount = "980",
            isLiked = false,
            userName = "RaviBhopara"
        ))

        activityMainBinding.apply {
            recylerViewAdapter = DatabindingRecylerViewAdapter(arrayList)
            recylerView.adapter = recylerViewAdapter
            showProgressBar = false
        }

    }
}
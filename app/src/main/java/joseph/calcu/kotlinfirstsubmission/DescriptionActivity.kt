package joseph.calcu.kotlinfirstsubmission

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DescriptionActivity : AppCompatActivity(){
    companion object {
        val descriptionID=4
        val POSITIONEXTRA="POS_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val intent = intent
        val data= intent.getParcelableExtra<LeagueItem>(POSITIONEXTRA)
        DescriptionActivityUI(data).setContentView(this)
    }

    fun isNullOrEmpty(str: String?): Boolean {
        if (str != null && !str.isEmpty())
            return false
        return true
    }
    class DescriptionActivityUI(var data: LeagueItem): AnkoComponent<DescriptionActivity>{
        override fun createView(ui: AnkoContext<DescriptionActivity>)=with(ui){
            linearLayout()
            {
                imageView(){
                    Glide.with(this).load(data.image).into(this)
//                    id =LeagueItemUi.imageId
                    padding = dip(16)
                    this@linearLayout.gravity=Gravity.CENTER_HORIZONTAL
                }.lparams(dip(100),dip(100))

                textView{
                    //                    id = LeagueItemUi.nameId
                    text = data.leaguename
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(16)
                }.lparams(wrapContent, wrapContent)

                textView{
                    //                    id = LeagueItemUi.nameId
                    text = data.description
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }
            }




        }



    }
}
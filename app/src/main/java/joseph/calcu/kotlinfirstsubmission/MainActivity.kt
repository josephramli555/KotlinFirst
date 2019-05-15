package joseph.calcu.kotlinfirstsubmission

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var leagueList : MutableList<LeagueItem> = mutableListOf()
    public val IntentTitle:String= "Title"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        MainActivityUI(leagueList).setContentView(this)
    }

    class MainActivityUI(var list: MutableList<LeagueItem>): AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>)=with(ui) {

           verticalLayout{
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL

               recyclerView(){
                    lparams(matchParent, matchParent)
                    layoutManager=LinearLayoutManager(context)
                    adapter=RecyclerViewAdapter(list){
                        startActivity<DescriptionActivity>(DescriptionActivity.POSITIONEXTRA to it)
                        val toast = Toast.makeText(context, it.id, Toast.LENGTH_SHORT)
                        toast.show()
                    }

               }
           }
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.league_name);
        val img = resources.obtainTypedArray(R.array.league_image)
        val desc = resources.getStringArray(R.array.league_description)
        val leagueid = resources.getStringArray(R.array.league_id);
        leagueList.clear()
        for(i in name.indices){
            leagueList.add(LeagueItem(name[i],img.getResourceId(i,0),desc[i],leagueid[i]))
        }
        img.recycle()
    }
}

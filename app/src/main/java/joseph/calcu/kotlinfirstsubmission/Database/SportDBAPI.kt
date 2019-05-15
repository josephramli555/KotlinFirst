package joseph.calcu.kotlinfirstsubmission.Database

import joseph.calcu.kotlinfirstsubmission.BuildConfig

object SportDBAPI {
    fun getLeague(league:String?):String{
        return BuildConfig.BASE_URL +"api/v1/json/1/"+"lookupleague.php?id="+league;
    }
}
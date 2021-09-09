package com.shao.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.shao.fragmentexample.Fragment.HomePage
import com.shao.fragmentexample.Fragment.RecordPage
import com.shao.fragmentexample.Fragment.SettingPage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fmgr:FragmentManager = supportFragmentManager
    private var transaction:FragmentTransaction = fmgr.beginTransaction()
    val mRecordPage:RecordPage = RecordPage.newInstance("test1", "test2")
    val mHomePage: HomePage = HomePage.newInstance("test3", "test4")
    val mSettingPage: SettingPage = SettingPage.newInstance("test5", "test6")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv.selectedItemId = R.id.homePage
        transaction = fmgr.beginTransaction()
        transaction.add(R.id.container, mHomePage)
        transaction.commit()
        /*
        bnv.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.recordPage->{
                    Log.d("Shao", "Record")
                    transaction = fmgr.beginTransaction()
                    transaction.replace(R.id.container, mRecordPage)
                    transaction.commit()
                }
                R.id.homePage-> {
                    Log.d("Shao", "Home")
                    transaction = fmgr.beginTransaction()
                    transaction.replace(R.id.container, mHomePage)
                    transaction.commit()
                }
                R.id.settingPage->{
                    Log.d("Shao", "Setting")
                    transaction = fmgr.beginTransaction()
                    transaction.replace(R.id.container, mSettingPage)
                    transaction.commit()
                }
            }
            true
        }
         */
        bnv.setOnItemSelectedListener(object: NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.recordPage->{
                        Log.d("Shao", "Record")
                        transaction = fmgr.beginTransaction()
                        transaction.replace(R.id.container, mRecordPage)
                        transaction.commit()
                    }
                    R.id.homePage-> {
                        Log.d("Shao", "Home")
                        transaction = fmgr.beginTransaction()
                        transaction.replace(R.id.container, mHomePage)
                        transaction.commit()
                    }
                    R.id.settingPage->{
                        Log.d("Shao", "Setting")
                        transaction = fmgr.beginTransaction()
                        transaction.replace(R.id.container, mSettingPage)
                        transaction.commit()
                    }
                }
                return true
            }
        })
    }
}
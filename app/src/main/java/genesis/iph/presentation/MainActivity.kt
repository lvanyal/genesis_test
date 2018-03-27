package genesis.iph.presentation

import android.app.Fragment
import android.app.FragmentManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.support.design.widget.TabItem
import android.support.design.widget.TabLayout
import android.support.v13.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import genesis.iph.R
import genesis.iph.presentation.movielist.FavoritesFragment
import genesis.iph.presentation.movielist.MoviesFragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        mSectionsPagerAdapter = SectionsPagerAdapter(fragmentManager)

        container.adapter = mSectionsPagerAdapter

        tabLayout.setupWithViewPager(container)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {

            return if (position == 0) MoviesFragment() else FavoritesFragment()
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence {
            return if (position == 0) "FILMS" else "FAVORITES"
        }
    }

}

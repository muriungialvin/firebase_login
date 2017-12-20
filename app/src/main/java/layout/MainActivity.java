package layout;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muriu.login.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by muriu on 12/20/2017.
 */

public class MainActivity extends Fragment {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] SLIDESHOW= {R.drawable.strath_logo,R.drawable.college_vote,R.drawable.screwy_students,R.drawable.voting};
    private ArrayList<Integer> SLIDESHOWArray = new ArrayList<Integer>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_slideshow, container, false);

    }





    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        for(int i=0;i<SLIDESHOW.length;i++)
            SLIDESHOWArray.add(SLIDESHOW[i]);


        mPager = (ViewPager) getView().findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(this ,SLIDESHOWArray));
        CircleIndicator indicator = (CircleIndicator) getView().findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == SLIDESHOW.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
}

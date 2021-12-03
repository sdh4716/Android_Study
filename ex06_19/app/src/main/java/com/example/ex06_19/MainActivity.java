package com.example.ex06_19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong, tabArtist, tabAlbum; //프래그먼트와 연결하기 위해 멤버변수로 격상
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //프래그먼트를 java로 만듦, xml이 추천되긴 함
        //1."액션바" 만들기
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        //2."탭" 만들기 - 액션바에 들어갈 탭, 탭 만들고 액션바에 꽂기
        tabSong = bar.newTab(); //탭 만들기
        tabSong.setText("음악별"); //탭 옵션 정하기
        tabSong.setTabListener(this); //탭에 리스너를 단다(이벤트 처리)
        //나 자신을 TabListener로 만들어 this를 사용할 수 있게끔 만들어 준다.
        bar.addTab(tabSong); //bar에 탭을 꽂는다

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }
    
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;
        MyTabFragment myFrags[] = new MyTabFragment[3];
        if(myFrags[tab.getPosition()]==null)// 눌러진 탭인덱스가 배열에 있는지 처음인지 구분
        {
            //처음이라면
            //1. 프래그먼트 생성 -> new MyFragment()
            //2. 옵션: 프래그먼트 안에 리니어 색상 결정
            // -> OS로 보내려면 Bundle이 필요 Bundle안에 key를 tabName으로 정함
            //3. 프래그먼트와 탭 연결

            //4. 새로 만든 프래그먼트 1개짜리를 프래그먼테 배열에 넣어주기
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        }
        else
            {
            myTabFrag = myFrags[tab.getPosition()];// (MyTabFragment)
        }
        //3. 프래그먼트와 탭 연결
        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    //3. "프래그먼트" 만들기
    //멤버 자리 - 1.멤버변수, 2.생성자, 3.메소드, 4.내부클래스

    public static class MyTabFragment extends Fragment{
        // alt + insert 키로, override method
        // 1. onCreate()와 2.onCreateView() 메소드 2개를 재정의한다.

        String tabName; //멤버변수로 격상됨, 왜? onCreateView()에서 계속 쓸거니까
        //탭과 프래그먼트(=me)를 연결하기 위해 탭이름과 프래그먼트 연동 설정
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Bundle data = getArguments();//OS와 통신
            tabName = data.getString("tabName");//OS의 Bundledml 키로 값을 가져옴
        }

        //프래그먼트 안에 들어갈 디자인 만들기, 예)리니어 레이아웃
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            //나는 프래그먼트 뷰임, 리니어레이아웃을 하나 가질 예정임
            LinearLayout.LayoutParams params
                    = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
                    LinearLayout baseLayout = new LinearLayout(super.getActivity());
                    baseLayout.setOrientation(LinearLayout.VERTICAL);

                    if(tabName == "음악별")
                        baseLayout.setBackgroundColor(Color.RED);
                    if(tabName == "가수별")
                        baseLayout.setBackgroundColor(Color.GREEN);
                    if(tabName == "앨범별")
                        baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;
        }
    }


}
package com.example.qplus.ui.market;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.qplus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class MarketBakeryActivity<StoreItem, sss1> extends AppCompatActivity {

    StorageReference storageRef;
    FirebaseStorage storage;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;

    ArrayList<QueryDocumentSnapshot> sendDocument;

    ListView listview;
    MarketListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_bakery);

        ImageView gohome;



        //이동
        gohome = findViewById(R.id.gohome);

        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Adapter 생성
        adapter = new MarketListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.market_listview);
        listview.setAdapter(adapter);

        MarketListClick marketListClick = new MarketListClick(getApplicationContext());
        marketListClick.MarketListClickBuy(adapter,listview,"Bakery");

        /*// db에서 갖고오기
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("MarketList").document("Bakery").get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot document = task.getResult();


                        // Adapter 생성
                        adapter = new MarketListViewAdapter();

                        // 리스트뷰 참조 및 Adapter달기
                        listview = (ListView) findViewById(R.id.market_listview);
                        listview.setAdapter(adapter);

                        for(int i = 1; i<5; i++ ) {
                            adapter.addItem(document.get("GoodsImg-" + i).toString(), document.get("GoodsName-" + i).toString(), document.get("Stamp-" + i).toString()+" 개");
                        }

                        Log.e("아이템이름","" + document.get("GoodsName-"+1).toString() );
                        Log.e("아이템개수","" + document.get("Stamp-"+1).toString() );
                        Log.e("아이템이미지","" + document.get("GoodsImg-"+3).toString() );


                    }
                });*/
        /*// 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.buy1),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.buy2),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.buy3),
                "CU 모바일 상품권 1만원", "10 스탬프") ;*/


    }
}

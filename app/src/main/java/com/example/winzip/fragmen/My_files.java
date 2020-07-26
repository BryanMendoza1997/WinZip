package com.example.winzip.fragmen;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.winzip.R;
import com.example.winzip.adaptadores.MyAdapter;
import com.example.winzip.clases.Archivos;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link My_files#newInstance} factory method to
 * create an instance of this fragment.
 */
public class My_files extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public My_files() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment My_files.
     */
    // TODO: Rename and change types and number of parameters
    public static My_files newInstance(String param1, String param2) {
        My_files fragment = new My_files();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ArrayList<Archivos> products;
    List<String> nombres;
    List<String> description;
    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }
    private List<String> getAlldescription(){
        return new ArrayList<String>(){{
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
            add("9 items 2020-07-22 23:08");
        }};
    }

    private List<String> getAllNames(){
        return new ArrayList<String>(){{
        add("Android");
        add("Alarms");
        add("Bluetooth");
        add("Boo");
        add("bytedance");
        add("CamScanner");
        add("DCIM");
        add("Facebook");
        add("Documents");
        add("Download");
        add("FaceApp");
        }};
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_my_files2, container, false);
        recyclerView=(RecyclerView) vista.findViewById(R.id.Recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        products=new ArrayList<>();
        agregardatos();
        MyAdapter adapter=new MyAdapter(products);
        recyclerView.setAdapter(adapter);
        return  vista;
    }
    public  void  agregardatos(){
        nombres=getAllNames();
        description=getAlldescription();
        for (int i=0 ;i < 11;i++){
            products.add( new Archivos(
                    nombres.get(i),
                    R.drawable.ic_carpeta,
                    description.get(i)
            ));
        }
    }
}
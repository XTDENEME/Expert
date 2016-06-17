package com.example.ext01d1840.expert;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link xtAnaSayfa.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link xtAnaSayfa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class xtAnaSayfa extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    String p_haber;
    String p_detay;
    int p_image;

    ListView lv;
    String[] haberT = {"Smart City Expo 2016 İstanbul","Dicle Elektrik Dağıtım A.Ş. Dijital Dönüşümde Experteam’i seçti.","Oracle Cloud Day 2016 Ankara’da gerçekleşti"
                        ,"Dördüncü Uluslararası İstanbul Akıllı Şebekeler ve Şehirler Kongresi","Oracle Mrd Day, Experteam’in Altın Sponsorluğunda gerçekleşti."};
    //
    int[] haberI= {R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5};
    //
    String[] detayT = {"Mobilite, İnovasyon ve Teknoloji , Enerji, Akıllı Toplum ,Girişimcilik ve Ekonomik Gelişme , Büyük Veri ve Kent Yönetimi konularının ele alınacağı ve Experteam’in Bronz sponsorluğunda destek verdiği Smart City Expo 2016 İstanbul etkinliği 1-3 Haziran 2016 tarihleri arasında Haliç Kongre Merkezi’nde gerçekleşecektir.",
                       "Hizmet kalitesini artırmak için teknolojiden azami istifade etmeyi amaçlayan Dicle Elektrik, kısa adı “3D” olan Dicle Dijital Dönüşüm Projesi’ni Experteam ile hayata geçiriyor. Projenin tanıtım toplantısında konuşan Dicle Elektrik Dağıtım Yönetim Kurulu Başkanı Memet Atalay, Türkiye’nin en çok gelişme kaydeden şirketi olmayı hedeflediklerini söyledi.\n" +
                               "\n" +
                               "Dicle Dijital Dönüşüm Projesi’nin tanıtım toplantısına, proje ile daha önce bir kısmı manuel olarak gerçekleştirilen müşteri hizmetleri, sayaç ve tahsilat işlemleri, mali işlemler, sayaç ve ekipman yönetimi, şebeke yönetimi, mobil işgücü yönetimi, bakım işlemlerinin tamamen dijital ortamda gerçekleştirileceği bildirildi.\n" +
                               "\n" +
                               "Tanıtım toplantısında konuşarak Dicle Dijital Dönüşüm Projesinin şirkete hayırlı olmasını dileyen Dicle Elektrik Dağıtım Yönetim Kurulu Başkanı Memet Atalay, yaptıkları çalışmalar nedeniyle şirket çalışanları ve çözüm ortaklarına teşekkür etti. Atalay konuşmasına, Dicle Elektrik Dağıtım’ın 6 ile yılda 22 milyar kWH elektrik dağıtımı yaptığını, istihdam açısından Türkiye’nin en büyük, dağıttığı enerji açısından ise 2. büyük dağıtım şirketi olduğunu hatırlattı. Dicle Elektrik’e münhasır birçok özellik bulunduğuna, bu nedenle de Dicle Dijital Dönüşüm Projesinin kendileri için bir şans olduğunu sözlerine ekleyen Memet Atalay, dağıtım yapılan illerdeki 6 milyar liralık kayıp Kaçak bulunduğunu kaydetti. Dicle Elektrik Dağıtım Yönetim Kurulu Başkanı Memet Atalay, ‘’Bunun yarısını israf olarak düşünürsek 3 milyar lira civarında bir rakam ediyor. Bu son derece ciddi bir rakam. Bu bile, projeyi başlatmamız için çok önemli bir sebeptir. Amacımız, Türkiye’de en çok gelişme kaydeden elektrik dağıtım şirketi olmaktır. Bunu yapma imkanına sahibiz” dedi.\n" +
                               "\n" +
                               "“TEKNOLOJİ DAHİL ÇOK CİDDİ EKSİKLER VARDI”\n" +
                               "\n" +
                               "Dicle Elektrik Perakende Yönetim Kurulu Başkanı Ahmet Demir ise, özelleşme ile şirket alındığında başta teknoloji olmak üzere çok ciddi eksiklerinin bulunduğuna dikkat çekti. Dicle Dijital Dönüşüm Projesinin hayata geçiriliyor olmasının çok heyecan verici olduğunu da kaydeden Demir, ‘’Bu proje inşallah bir milat olacak” diye konuştu.\n" +
                               "\n" +
                               "“HEPİMİZ BU PROJENİN SAHİBİYİZ”\n" +
                               "\n" +
                               "Daha sonra söz alan Dicle Elektrik Dağıtım Genel Müdürü Murat Karagüzel de özelleşme sonrasında yaşadıkları teknolojik imkansızlıklara değinerek, “Günlük tahsilata dahi bakamıyorduk. Bakabilmek için TEDAŞ Genel Müdürlüğü’ne yazı yazıyorduk. O günden bu güne geldik” ifadelerinde bulundu.\n" +
                               "\n" +
                               "Tanıtımı yapılan ve bir süre sonra hayata geçirilmesi planlanan 3D projesine ciddi destek verilmesi gerektiğinin altını çizen Karagüzel, şunları söyledi:\n" +
                               "\n" +
                               "‘’Hepimiz bu projenin sahibiyiz. Bütün saha çalışanları olarak bu projeye elimizden gelen desteği vereceğiz. Biz çok zor işleri başaran bir ekibiz. Bu projenin de hayırlı olmasını diliyorum’’ dedi.\n" +
                               "\n" +
                               "Dicle Elektrik Perakende Genel Müdürü Avni Doğan ise bu projeye sadece destek vermeyeceklerini, ayrıca sahip de çıkacaklarını belirterek, “Bu proje hayata geçtiğinde bizden de izler taşıyacak” dedi.\n" +
                               "\n" +
                               "Tanıtım toplantısında konuşan Teknoloji Başkanı Kürşad Karaman da Dicle Elektrik’te kendilerini bir şeyler yapmaya zorlayan bir saha ekibinin varlığına değinerek, “Bu sinerji, birlik ve beraberlik olmadan hiçbir şey yapmamız mümkün değildi. Nihai hedefimiz, tamamen dijital ortama geçmektir”’ diye konuştu." ,
                    "Experteam’in Altın sponsorluğunda gerçekleşen Oracle Cloud Day 2016 Rixos Grand Ankara’da gerçekleşti. Etklinlikte Pazarlama ve Satış Genel Müdür Yardımcımız Sinan Erkiner yönetilen hizmetlerimizi anlatırken, Müşteri Başarı Hikayesi slotumuzun konuşmacısı İş Geliştirme Direktörümüz Alp Pekin oldu.",
                    "ICSG 2016, akıllı şebekeler ve şehirler, akıllı ulaşım sistem araştırmacıları, uygulayıcıları, geliştiricileri ve kullanıcıları için üstün fikirleri ve üst düzey teknoloji ürünlerini tartışmak ve keşfetmek, teknikleri, araçları ve deneyimleri paylaşmak için uluslararası önemli bir toplantıdır.\n" +
                            "\n" +
                            "Experteam’in gümüş sponsor olarak yer alacağı Icsg etkinliği, 20-21 Nisan 2016 tarihlerinde İstanbul Haliç Kongre Merkezi’nde gerçekleşecektir.",
                    "10 Şubat 2016 tarihinde gerçekleşen altın sponsor olarak yer aldığımız Oracle Mrd Day etkinliğinde, Pazarlama ve Satış Genel Müdür Yardımcısı Sinan Erkiner Yönetilen Hizmetlerimizi anlattı."};

    public xtAnaSayfa() {

        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters


    public static xtAnaSayfa newInstance(String param1, String param2) {

        xtAnaSayfa fragment = new xtAnaSayfa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



       View rootView = inflater.inflate(R.layout.fragment_xt_ana_sayfa, container, false);

        lv = (ListView) rootView.findViewById(R.id.anaView);
        haberAdaptor adapter=new haberAdaptor(getActivity(),haberT,haberI);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                p_haber = haberT[pos];
                p_detay =detayT[pos];
                p_image = haberI[pos];

                Intent intent = new Intent(getActivity(), xtHaberDetay.class);
                intent.putExtra("p_haber",p_haber);
                intent.putExtra("p_detay",p_detay);
                intent.putExtra("p_image",p_image);
                startActivity(intent);
                //Toast.makeText(getActivity(),haberT[pos],Toast.LENGTH_LONG).show();
            }
        });
        return rootView;


    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}

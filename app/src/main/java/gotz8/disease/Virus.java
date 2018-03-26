package gotz8.disease;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class Virus extends AppCompatActivity {
    ListView listViewVir;

    Button finddis;
    EditText search_dis;
    int VirID;

    String word_search;
    ArrayList<HashMap<String, String>> MyarrayList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virus);

        search_dis = (EditText) findViewById(R.id.search_dis);
        finddis = (Button) findViewById(R.id.finddis);


        listViewVir = (ListView) findViewById(R.id.listViewvir);

        myDBClass dbHelper = new myDBClass(this);

        SQLiteDatabase db;
        dbHelper.getWritableDatabase();
        db = dbHelper.getWritableDatabase();


        finddis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word_search = search_dis.getText().toString();
                setAdapterList(word_search);
            }
        });

        db.execSQL("DROP TABLE IF EXISTS VirusTable");
        //db.execSQL("DELETE FROM VirusTable WHERE 1=1");
        //db.execSQL("INSERT INTO VirusTable values(null,'" + i + "','"+i+"','"+i+"');");
        db.execSQL("CREATE TABLE IF NOT EXISTS VirusTable" +
                "(VIR_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " VIR_NAME_EN TEXT(100)," +
                " VIR_NAME_TH TEXT(100)," +
                " VIR_VACCINE TEXT(100)," +
                " VIR_DATA TEXT(400));");



        int count = Integer.parseInt(DatabaseUtils.stringForQuery(db,"SELECT COUNT(*) FROM VirusTABLE",null));
        if(count == 0){
            db.execSQL("INSERT INTO VirusTable values (null,'Rabies','โรคพิษสุนัขบ้า','Imovax®','เป็นโรคไวรัสที่ทำให้เกิดการอักเสบเฉียบพลันของสมองในมนุษย์และสัตว์เลือดอุ่นชนิดอื่น อาการเริ่มต้นมีไข้และอาการเป็นเหน็บ ณ ตำแหน่งสัมผัส อาการเหล่านี้ตามด้วยอาการต่อไปนี้อย่างหนึ่งหรือมากกว่า ได้แก่ การเคลื่อนไหวรุนแรง ความตื่นเต้นควบคุมไม่ได้ กลัวน้ำ ไม่สามารถขยับร่างกายบางส่วน สับสนและไม่รู้สึกตัว เมื่อเกิดอาการแล้ว จะลงเอยด้วยถึงแก่ชีวิตแทบทั้งสิ้น');");
            db.execSQL("INSERT INTO VirusTable values (null,'Ebola','โรคไวรัสอิโบล่า',null,'เป็นโรคของมนุษย์ที่เกิดจากไวรัสอีโบลา จะเริ่มมีอาการสองวันถึงสามสัปดาห์หลังสัมผัสไวรัส โดยมีไข้ เจ็บคอ ปวดกล้ามเนื้อและปวดศีรษะ จากนั้นมีอาการคลื่นไส้ อาเจียนและท้องร่วงร่วมกับการทำหน้าที่ของตับและไตลดลงตามมา เมื่อถึงจุดนี้ บางคนเริ่มมีปัญหาเลือดออก');");
            db.execSQL("INSERT INTO VirusTable values (null,'Dengue','โรคไข้เลือดออก','Dengvaxia (CYD-TDV)','เป็นโรคติดเชื้อซึ่งระบาดในเขตร้อน เกิดจากการติดเชื้อไวรัสเด็งกี ผู้ป่วยจะมีอาการไข้ ปวดศีรษะ ปวดกล้ามเนื้อ ปวดข้อ และมีผื่นลักษณะเฉพาะซึ่งคล้ายกับผื่นของโรคหัด ผู้ป่วยส่วนหนึ่งจะมีอาการรุนแรง จนกลายเป็นไข้เลือดออก เป็นอันตรายถึงชีวิต ซึ่งทำให้มีเลือดออกง่าย มีเกล็ดเลือดต่ำ และมีการรั่วของพลาสมา หรือรุนแรงมากขึ้น');");
            db.execSQL("INSERT INTO VirusTable values (null,'HIV','โรคเอดส์','HVTN 702',' เป็นโรคของระบบภูมิคุ้มกันของมนุษย์ ซึ่งเกิดจากการติดเชื้อไวรัสเอชไอวี ทำให้ผู้ป่วยมีการทำงานของระบบภูมิคุ้มกันบกพร่อง เสี่ยงต่อการติดเชื้อฉวยโอกาสและการเกิดเนื้องอกบางชนิด เชื้อไวรัสเอชไอวีติดต่อผ่านทางการสัมผัสของเยื่อเมือกหรือการสัมผัสสารคัดหลั่งซึ่งมีเชื้อ เช่น เลือด น้ำอสุจิ น้ำหล่อลื่นในช่องคลอด น้ำหลั่งก่อนการหลั่งอสุจิ ');");
            db.execSQL("INSERT INTO VirusTable values (null,'Japanese Encephalitis','โรคไข้สมองอักเสบ','Ixiaro®','เป็นโรคที่ทำให้เกิดโรคทางสมองและระบบประสาทเป็นส่วนใหญ่ เป็นโรคที่เกิดจากเชื้อไวรัสหลายชนิด แต่ที่เป็นสาเหตุมากที่สุดในประเทศไทยขณะนี้คือ เชื้อไวรัสแจแปนนีส เอนเซปฟาไลตีสซึ่งพบว่าเป็นสาเหตุสูงถึง 65-82% ส่วนใหญ่ในเนื้อหาต่อไปนี้ จึงจะเป็นเรื่องจองไข้สมองอักเสบจากเชื้อไวรัส JE นี้ เนื่องจากพบได้บ่อย มีการเกิดโรคได้รุนแรงกว่าชนิดอื่น ๆ อัตราตายสูงและมีความพิการทางระบบประสาทหลงเหลือได้สูง');");
            db.execSQL("INSERT INTO VirusTable values (null,'SLE','โรคแพ้ภูมิตัวเอง',null,'เป็นโรคภูมิต้านตนเองชนิดหนึ่ง เกิดจากการที่ระบบภูมิคุ้มกันของร่างกายทำงานผิดปกติ จึงเข้าโจมตีเนื้อเยื่อปกติของร่างกายทำให้เกิดอาการป่วย ผู้ป่วยอาจมีอาการได้หลายแบบตั้งแต่เล็กน้อยแทบไม่มีอาการไปจนถึงรุนแรงอาจถึงแก่ชีวิต อาการที่พบบ่อยได้แก่ ข้ออักเสบ มีไข้ เจ็บหน้าอก ผมร่วง แผลในปาก ซึ่งมักพบที่บริเวณใบหน้า ผู้ป่วยมักมีระยะที่อาการเป็นมาก อาจเรียกว่าระยะกำเริบ และระยะที่อาการเป็นน้อย เรียกว่าระยะสงบ');");
            db.execSQL("INSERT INTO VirusTable values (null,'Herpes simplex','โรคเริม','HSV-2','เป็นโรคผิวหนังที่เกิดจากเชื้อไวรัส Herpes simplex ซึ่งเชื้อไวรัสตัวนี้มีอยู่ 2 ชนิด คือ ชนิดที่ทำให้เกิดแผลที่พบบริเวณริมฝีปากทั้งบนและล่างหรือมุมปาก พบได้ทั้งในเด็กและผู้ใหญ่ และชนิดที่มักจะพบเริมบริเวณอวัยวะเพศ พบในผู้ใหญ่มากกว่าเด็ก ลักษณะอาการแบ่งได้เป็นหลายระยะ โดยจะเริ่มจากความรู้สึกคันหรือเจ็บยิบๆบริเวณที่จะเกิดแผล แล้วจะมีผื่น กลายเป็นกลุ่มของตุ่มน้ำใสซึ่งภายหลังจะรวมตัวกันอยู่บนผิวหนังประมาณ 1-2 วัน จากนั้นตุ่มน้ำใสนี้ จะแตกออก และตกสะเก็ด');");
            db.execSQL("INSERT INTO VirusTable values (null,'Herpes zoster','โรคงูสวัด','Zostavax','เกิดจากเชื้อไวรัสวาริเซลลาซอสเตอร์ (varicella-zoster virus) เป็นคนละโรคกับ โรคเริม คนที่เป็นโรคงูสวัดจะต้องเคยเป็นโรคอีสุกอีใสมาก่อน เมื่อภูมิต้านทานอ่อนแอลงจึงกลายเป็นโรคงูสวัด มักจะเป็นผื่นตามแนว dermatome แนวเส้นประสาทของผิวหนัง และมักจะปวดมาก โรคนี้ไม่ติดต่อระหว่างคนสู่คน แต่การได้รับไวรัสที่พบในตุ่มสามารถก่อโรคสุกใสในผู้ที่ไม่เคยเป็นได้');");
            db.execSQL("INSERT INTO VirusTable values (null,'Sinus','โรคไซนัสอักเสบ','Pneumococcal Vaccines','การอักเสบของเยื่อภายในไซนัส ซึ่งมีลักษณะเบา ๆ ประมาณ 0.5-1 มม. อาจเกิดจากเชื้อไวรัส ไม่มีหนอง, เกิดจากเชื้อหนอง แบคทีเรีย หรือเกิดจากสารที่ระคายเคือง เช่น พวกกรด ด่าง ควัน และสารพิษ อื่น ๆ นอกจากนี้อาจเกิดจากโรคภูมิแพ้ ก็ได้ ปัญหาใหญ่ของโรคไซนัสอักเสบนั้น เกิดจากเชื้อหนอง แบ่งออกได้เป็น ระยะเฉียบพลัน และระหว่างเรื้อรัง');");
            db.execSQL("INSERT INTO VirusTable values (null,'Cirrhosis','โรคตับแข็ง','Twinrix (GSK)',' เป็นภาวะซึ่งเป็นผลจากโรคตับเรื้อรัง มีลักษณะเฉพาะคือการมีเนื้อเยื่อพังผืดเกิดขึ้นในเนื้อตับ ดึงรั้งเนื้อตับดีจนเป็นผิวตะปุ่มตะป่ำเรียกว่า regenerative nodule ทำให้ตับเสียการทำงานลงไป ตับแข็งมักเกิดขึ้นเป็นผลจากพิษสุราเรื้อรัง ตับอักเสบจากไวรัส (โดยเฉพาะจากไวรัสตับอักเสบบีและซี) และโรคตับคั่งไขมัน รวมถึงสาเหตุอื่น ๆ อีกหลายอย่าง');");
            db.execSQL("INSERT INTO VirusTable values (null,'Avian influenza','โรคไข้หวัดนก','Oseltamivir','เป็นโรคที่เกิดจากไวรัสไข้หวัดใหญ่ชื่อ H5N1 ซึ่งพบได้ในสัตว์ปีก ค้นพบครั้งแรกในช่วงต้นคริสต์ศตวรรษที่ 19 ในประเทศอิตาลี เรียกกันว่าไข้หวัดสเปน โรคนี้ระบาดอย่างหนักทั่วโลก ไข้วก ไข้หวัดนก เอาอีก เริ่มระบาดครั้งแรกในปี พ.ศ. 2460-2461 เรียกว่า ไข้หวัดใหญ่สเปน เริ่มแพร่ระบาดจากฝั่งอาร์กติก และข้ามมาสู่ฝั่งแปซิฟิกภายในระยะเวลา2เดือน');");
            db.execSQL("INSERT INTO VirusTable values (null,'Chronic Fatigue Syndrome','โรคซีเอฟเอส',null,'มีอาการเหนื่อยล้า อ่อนเพลียอยู่ตลอดเวลา และบางครั้งมีอาการปวดกล้ามเนื้อ ปวดข้อ ปวดหัว  รู้สึกเจ็บคอ มีอาการหนาวสั่น หรือไข้เล็กน้อยได้ โดยมีข้อสันนิษฐานทางทฤษฎีที่คาดว่าโรคอ่อนเพลียเรื้อรังมีสาเหตุเกิดมาจากเชื้อไวรัสหรือสารเคมีบางชนิดเข้าไปทำลายระบบภูมิคุ้มกันในร่างกาย ส่งผลให้เชื้อไวรัสหลายชนิดที่อยู่ในร่างกายแต่เดิมแต่ไม่ได้แสดงอาการชัดออกมาอาละวาด ซึ่งทำให้เม็ดเลือดขาวในร่างกายจัดส่งสารเคมีที่มีฤทธิ์รุนแรงมาจัดการไวรัสเหล่านี้ เรียกว่า ไซโตไคน์ (Cytokine) ซึ่งส่งผลให้เม็ดเลือดขาวชนิดทีเซลล์ไม่ทำงานตามปกติ');");
            db.execSQL("INSERT INTO VirusTable values (null,'Human Papillomavirus','โรคติดเชื้อเอชพีวี','Gardasil®9','โรคที่เกิดจากร่างกายติดเชื้อไวรัสชนิดที่เรียกว่า ไวรัสเอชพีวี HPV หรือ Human papillomavirus ซึ่งเป็นไวรัสสายพันธุ์ในตระกูล Family Papillomavirus ซึ่งมีมากกว่า 150 สายพันธุ์ย่อย โดยไว้รัสแต่ละตัวในกลุ่มนี้จะมีตัวเลขระบุสายพันธุ์ย่อย เชื้อ HPV บางสายพันธุ์สามารถทำให้เกิดหูดที่ผิวหนังได้ ยิ่งไปกว่านั้นบางสายพันธุ์สามารถทำให้เกิดโรคมะเร็งได้');");
            db.execSQL("INSERT INTO VirusTable values (null,'Viral meningitis','โรคเยื่อหุ้มสมองอักเสบ',null,'เป็นภาวะที่มีการอักเสบของเยื่อที่อยู่รอบสมองและไขสันหลังซึ่งเรียกรวมว่าเยื่อหุ้มสมอง การอักเสบนี้อาจเกิดจากการติดเชื้อไวรัส แบคทีเรีย หรือจุลชีพอื่นๆ และบางครั้งเกิดจากยาบางชนิด เป็นภาวะที่อาจเป็นอันตรายถึงชีวิตเนื่องจากเป็นการอักเสบที่อยู่ใกล้เนื้อสมองและไขสันหลัง ดังนั้นจึงเป็นภาวะฉุกเฉินทางการแพทย์');");
            db.execSQL("INSERT INTO VirusTable values (null,'MERS','โรคเมอร์ส',null,'โรคติดเชื้อไวรัสโคโรน่าสายพันธุ์ใหม่ 2012 เป็นการติดเชื้อไวรัสในระบบหายใจจากเชื้อไวรัสสายพันธุ์ใหม่ MERS-CoV ซึ่งเป็นเบตาโคโรนาไวรัสที่เคยติดต่อในค้างคาว และยังตรวจพบภูมิคุ้มกันต่อไวรัสนี้ในอูฐ อย่างไรก็ดีแหล่งที่มาของเชื้อนี้ยังไม่ชัดเจน');");
            db.execSQL("INSERT INTO VirusTable values (null,'Salmonella','โรคติดเชื้อซาลโมเนลลา','Fluoroquinolone','เป็นกลุ่มของแบคทีเรียที่มักก่อให้เกิดโรคผ่านทางการรับประทานอาหารในสหรัฐอเมริกา การติดเชื้อแบคทีเรียชนิดนี้จะเรียกว่า Salmonellosis และสามารถติดได้ผ่านการรับประทานอาหารที่ปนเปื้อนเชื้อ เช่น เนื้อสัตว์ปีกดิบ ๆ ไข่ เนื้อวัว และผลไม้และผักที่ไม่ได้ล้างทำความสะอาด นอกจากนี้ สัตว์เลี้ยงบางชนิด โดยเฉพาะในกลุ่มสัตว์เลื้อยคลานเช่นงู เต่า หรือกิ้งก่าสามารถทำให้เกิดการแพร่เชื้อได้เช่นกัน');");
            db.execSQL("INSERT INTO VirusTable values (null,'Zika fever','โรคไข้ซิกา','NSAIDs','เป็นโรคติดเชื้ออย่างหนึ่งเกิดจากเชื้อไวรัสซิกา ผู้ป่วยส่วนใหญ่ไม่มีอาการ หรือมีอาการเล็กน้อยคล้ายกับไข้เดงกีอาการมักคงอยู่ไม่เกินเจ็ดวัน โดยอาการเหล่านี้เช่น ไข้ ตาแดง ปวดข้อ ปวดหัว ผื่นแดง เป็นต้นยังไม่มีรายงานว่ามีผู้ป่วยเสียชีวิตจากโรคนี้ ภาวะนี้สัมพันธ์กับการเกิดกลุ่มอาการกิลแลงบาร์เรอีกด้วย ไข้ซิกาติดต่อผ่านทางการถูกยุง Aedes เช่น ยุงลาย กัด เป็นส่วนใหญ่ ');");

        }
        db.close();
        // get Data from SQLite
        setAdapterList("");

    }

    public void setAdapterList(String keyword){
        try{
            myDBClass myDb = new myDBClass(this);
            MyarrayList = myDb.SelectVirusTableData(this,keyword);
            // listView1
            final SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(Virus.this, MyarrayList, R.layout.activity_list_virus
                    ,new String[] {"VIR_NAME_EN", "VIR_NAME_TH", "VIR_VACCINE","VIR_DATA"}
                    ,new int[] {R.id.VirNameEng, R.id.VirNameTH, R.id.VirVaccine,R.id.VirDT});
            listViewVir.setAdapter(sAdap);
            listViewVir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    //               String item = VirusList.get(i).get("VIR_NAME_EN");

                    String item2 =MyarrayList.get(i).get("VIR_NAME_EN");
                    String item3 =MyarrayList.get(i).get("VIR_DATA");

                    Intent intent = new Intent(Virus.this,VirusData.class);

                    intent.putExtra("VIR_NAME_EN",item2);
                    intent.putExtra("VIR_DATA",item3);
                    startActivity(intent);

/*
                   Context context = getApplicationContext();
                 int duration = Toast.LENGTH_SHORT;
                   Toast toast = Toast.makeText(context, item, duration);
                 toast.show();
*/
//                    ClickVirus();
                }
            });
        }catch (Exception ex){
            Toast.makeText(Virus.this,ex.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }

    public void ClickVirus (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome



}
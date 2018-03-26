package gotz8.disease;

/**
 * Created by Gotz8 on 3/22/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "DiseaseMonitor";
    private static final int DB_VERSION = 1;

    public static final String VIRUS = "VirusTable";
    public static final String VIR_NAME_EN = "VIR_NAME_EN";
    public static final String VIR_NAME_TH = "VIR_NAME_TH";
    public static final String VIR_VACCINE = "VIR_VACCINE";
    public static final String VIR_DATA = "VIR_DATA";

    public static final String BACTERIA = "BacTable";
    public static final String BAC_NAME_EN = "BAC_NAME_EN";
    public static final String BAC_NAME_TH = "BAC_NAME_TH";
    public static final String BAC_VACCINE = "BAC_VACCINE";
    public static final String BAC_DATA = "BAC_DATA";

    public static final String VACCINE = "VacTable";
    public static final String VAC_NAME = "VAC_NAME";
    public static final String VAC_PRODUCT_DIS= "VAC_PRODUCT_DIS";
    public static final String VAC_YEAR_PD = "VAC_YEAR_PD";
    public static final String VAC_MANUFACTURER = "VAC_MANUFACTURER";
    public static final String VAC_TYPE = "VAC_TYPE";
    public static final String VAC_DESCRIPTION = "VAC_DESCRIPTION";
    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ VIRUS +" (VIR_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + VIR_NAME_EN + " TEXT, " + VIR_NAME_TH + " TEXT, " + VIR_VACCINE + " TEXT, "
                + VIR_DATA  + " TEXT);");

        db.execSQL("CREATE TABLE "+ BACTERIA +" (BAC_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BAC_NAME_EN + " TEXT, " + BAC_NAME_TH + " TEXT, " + BAC_VACCINE + " TEXT, "
                + BAC_DATA  + " TEXT);");
        db.execSQL("CREATE TABLE "+ VACCINE +" (VAC_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + VAC_NAME + " TEXT, " + VAC_PRODUCT_DIS + " TEXT, " + VAC_YEAR_PD + " TEXT, "
                + VAC_MANUFACTURER + " TEXT, " + VAC_TYPE + " TEXT, "   + VAC_DESCRIPTION  + " TEXT);");

        //Virus Table
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Rabies','โรคพิษสุนัขบ้า','Imovax®','เป็นโรคไวรัสที่ทำให้เกิดการอักเสบเฉียบพลันของสมองในมนุษย์และสัตว์เลือดอุ่นชนิดอื่น อาการเริ่มต้นมีไข้และอาการเป็นเหน็บ ณ ตำแหน่งสัมผัส อาการเหล่านี้ตามด้วยอาการต่อไปนี้อย่างหนึ่งหรือมากกว่า ได้แก่ การเคลื่อนไหวรุนแรง ความตื่นเต้นควบคุมไม่ได้ กลัวน้ำ ไม่สามารถขยับร่างกายบางส่วน สับสนและไม่รู้สึกตัว เมื่อเกิดอาการแล้ว จะลงเอยด้วยถึงแก่ชีวิตแทบทั้งสิ้น');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Ebola','โรคไวรัสอิโบล่า',null,'เป็นโรคของมนุษย์ที่เกิดจากไวรัสอีโบลา จะเริ่มมีอาการสองวันถึงสามสัปดาห์หลังสัมผัสไวรัส โดยมีไข้ เจ็บคอ ปวดกล้ามเนื้อและปวดศีรษะ จากนั้นมีอาการคลื่นไส้ อาเจียนและท้องร่วงร่วมกับการทำหน้าที่ของตับและไตลดลงตามมา เมื่อถึงจุดนี้ บางคนเริ่มมีปัญหาเลือดออก');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Dengue','โรคไข้เลือดออก','Dengvaxia (CYD-TDV)','เป็นโรคติดเชื้อซึ่งระบาดในเขตร้อน เกิดจากการติดเชื้อไวรัสเด็งกี ผู้ป่วยจะมีอาการไข้ ปวดศีรษะ ปวดกล้ามเนื้อ ปวดข้อ และมีผื่นลักษณะเฉพาะซึ่งคล้ายกับผื่นของโรคหัด ผู้ป่วยส่วนหนึ่งจะมีอาการรุนแรง จนกลายเป็นไข้เลือดออก เป็นอันตรายถึงชีวิต ซึ่งทำให้มีเลือดออกง่าย มีเกล็ดเลือดต่ำ และมีการรั่วของพลาสมา หรือรุนแรงมากขึ้น');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('HIV','โรคเอดส์','HVTN 702',' เป็นโรคของระบบภูมิคุ้มกันของมนุษย์ ซึ่งเกิดจากการติดเชื้อไวรัสเอชไอวี ทำให้ผู้ป่วยมีการทำงานของระบบภูมิคุ้มกันบกพร่อง เสี่ยงต่อการติดเชื้อฉวยโอกาสและการเกิดเนื้องอกบางชนิด เชื้อไวรัสเอชไอวีติดต่อผ่านทางการสัมผัสของเยื่อเมือกหรือการสัมผัสสารคัดหลั่งซึ่งมีเชื้อ เช่น เลือด น้ำอสุจิ น้ำหล่อลื่นในช่องคลอด น้ำหลั่งก่อนการหลั่งอสุจิ ');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Japanese Encephalitis','โรคไข้สมองอักเสบ','Ixiaro®','เป็นโรคที่ทำให้เกิดโรคทางสมองและระบบประสาทเป็นส่วนใหญ่ เป็นโรคที่เกิดจากเชื้อไวรัสหลายชนิด แต่ที่เป็นสาเหตุมากที่สุดในประเทศไทยขณะนี้คือ เชื้อไวรัสแจแปนนีส เอนเซปฟาไลตีสซึ่งพบว่าเป็นสาเหตุสูงถึง 65-82% ส่วนใหญ่ในเนื้อหาต่อไปนี้ จึงจะเป็นเรื่องจองไข้สมองอักเสบจากเชื้อไวรัส JE นี้ เนื่องจากพบได้บ่อย มีการเกิดโรคได้รุนแรงกว่าชนิดอื่น ๆ อัตราตายสูงและมีความพิการทางระบบประสาทหลงเหลือได้สูง');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('SLE','โรคแพ้ภูมิตัวเอง',null,'เป็นโรคภูมิต้านตนเองชนิดหนึ่ง เกิดจากการที่ระบบภูมิคุ้มกันของร่างกายทำงานผิดปกติ จึงเข้าโจมตีเนื้อเยื่อปกติของร่างกายทำให้เกิดอาการป่วย ผู้ป่วยอาจมีอาการได้หลายแบบตั้งแต่เล็กน้อยแทบไม่มีอาการไปจนถึงรุนแรงอาจถึงแก่ชีวิต อาการที่พบบ่อยได้แก่ ข้ออักเสบ มีไข้ เจ็บหน้าอก ผมร่วง แผลในปาก ซึ่งมักพบที่บริเวณใบหน้า ผู้ป่วยมักมีระยะที่อาการเป็นมาก อาจเรียกว่าระยะกำเริบ และระยะที่อาการเป็นน้อย เรียกว่าระยะสงบ');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Herpes simplex','โรคเริม','HSV-2','เป็นโรคผิวหนังที่เกิดจากเชื้อไวรัส Herpes simplex ซึ่งเชื้อไวรัสตัวนี้มีอยู่ 2 ชนิด คือ ชนิดที่ทำให้เกิดแผลที่พบบริเวณริมฝีปากทั้งบนและล่างหรือมุมปาก พบได้ทั้งในเด็กและผู้ใหญ่ และชนิดที่มักจะพบเริมบริเวณอวัยวะเพศ พบในผู้ใหญ่มากกว่าเด็ก ลักษณะอาการแบ่งได้เป็นหลายระยะ โดยจะเริ่มจากความรู้สึกคันหรือเจ็บยิบๆบริเวณที่จะเกิดแผล แล้วจะมีผื่น กลายเป็นกลุ่มของตุ่มน้ำใสซึ่งภายหลังจะรวมตัวกันอยู่บนผิวหนังประมาณ 1-2 วัน จากนั้นตุ่มน้ำใสนี้ จะแตกออก และตกสะเก็ด');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Herpes zoster','โรคงูสวัด','Zostavax','เกิดจากเชื้อไวรัสวาริเซลลาซอสเตอร์ (varicella-zoster virus) เป็นคนละโรคกับ โรคเริม คนที่เป็นโรคงูสวัดจะต้องเคยเป็นโรคอีสุกอีใสมาก่อน เมื่อภูมิต้านทานอ่อนแอลงจึงกลายเป็นโรคงูสวัด มักจะเป็นผื่นตามแนว dermatome แนวเส้นประสาทของผิวหนัง และมักจะปวดมาก โรคนี้ไม่ติดต่อระหว่างคนสู่คน แต่การได้รับไวรัสที่พบในตุ่มสามารถก่อโรคสุกใสในผู้ที่ไม่เคยเป็นได้');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Sinus','โรคไซนัสอักเสบ','Pneumococcal Vaccines','การอักเสบของเยื่อภายในไซนัส ซึ่งมีลักษณะเบา ๆ ประมาณ 0.5-1 มม. อาจเกิดจากเชื้อไวรัส ไม่มีหนอง, เกิดจากเชื้อหนอง แบคทีเรีย หรือเกิดจากสารที่ระคายเคือง เช่น พวกกรด ด่าง ควัน และสารพิษ อื่น ๆ นอกจากนี้อาจเกิดจากโรคภูมิแพ้ ก็ได้ ปัญหาใหญ่ของโรคไซนัสอักเสบนั้น เกิดจากเชื้อหนอง แบ่งออกได้เป็น ระยะเฉียบพลัน และระหว่างเรื้อรัง');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Cirrhosis','โรคตับแข็ง','Twinrix (GSK)',' เป็นภาวะซึ่งเป็นผลจากโรคตับเรื้อรัง มีลักษณะเฉพาะคือการมีเนื้อเยื่อพังผืดเกิดขึ้นในเนื้อตับ ดึงรั้งเนื้อตับดีจนเป็นผิวตะปุ่มตะป่ำเรียกว่า regenerative nodule ทำให้ตับเสียการทำงานลงไป ตับแข็งมักเกิดขึ้นเป็นผลจากพิษสุราเรื้อรัง ตับอักเสบจากไวรัส (โดยเฉพาะจากไวรัสตับอักเสบบีและซี) และโรคตับคั่งไขมัน รวมถึงสาเหตุอื่น ๆ อีกหลายอย่าง');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Avian influenza','โรคไข้หวัดนก','Oseltamivir','เป็นโรคที่เกิดจากไวรัสไข้หวัดใหญ่ชื่อ H5N1 ซึ่งพบได้ในสัตว์ปีก ค้นพบครั้งแรกในช่วงต้นคริสต์ศตวรรษที่ 19 ในประเทศอิตาลี เรียกกันว่าไข้หวัดสเปน โรคนี้ระบาดอย่างหนักทั่วโลก ไข้วก ไข้หวัดนก เอาอีก เริ่มระบาดครั้งแรกในปี พ.ศ. 2460-2461 เรียกว่า ไข้หวัดใหญ่สเปน เริ่มแพร่ระบาดจากฝั่งอาร์กติก และข้ามมาสู่ฝั่งแปซิฟิกภายในระยะเวลา 2 เดือน');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Chronic Fatigue Syndrome','โรคซีเอฟเอส',null,'มีอาการเหนื่อยล้า อ่อนเพลียอยู่ตลอดเวลา และบางครั้งมีอาการปวดกล้ามเนื้อ ปวดข้อ ปวดหัว  รู้สึกเจ็บคอ มีอาการหนาวสั่น หรือไข้เล็กน้อยได้ โดยมีข้อสันนิษฐานทางทฤษฎีที่คาดว่าโรคอ่อนเพลียเรื้อรังมีสาเหตุเกิดมาจากเชื้อไวรัสหรือสารเคมีบางชนิดเข้าไปทำลายระบบภูมิคุ้มกันในร่างกาย ส่งผลให้เชื้อไวรัสหลายชนิดที่อยู่ในร่างกายแต่เดิมแต่ไม่ได้แสดงอาการชัดออกมาอาละวาด ซึ่งทำให้เม็ดเลือดขาวในร่างกายจัดส่งสารเคมีที่มีฤทธิ์รุนแรงมาจัดการไวรัสเหล่านี้ เรียกว่า ไซโตไคน์ (Cytokine) ซึ่งส่งผลให้เม็ดเลือดขาวชนิดทีเซลล์ไม่ทำงานตามปกติ');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Human Papillomavirus','โรคติดเชื้อเอชพีวี','Gardasil®9','โรคที่เกิดจากร่างกายติดเชื้อไวรัสชนิดที่เรียกว่า ไวรัสเอชพีวี HPV หรือ Human papillomavirus ซึ่งเป็นไวรัสสายพันธุ์ในตระกูล Family Papillomavirus ซึ่งมีมากกว่า 150 สายพันธุ์ย่อย โดยไว้รัสแต่ละตัวในกลุ่มนี้จะมีตัวเลขระบุสายพันธุ์ย่อย เชื้อ HPV บางสายพันธุ์สามารถทำให้เกิดหูดที่ผิวหนังได้ ยิ่งไปกว่านั้นบางสายพันธุ์สามารถทำให้เกิดโรคมะเร็งได้');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Viral meningitis','โรคเยื่อหุ้มสมองอักเสบ',null,'เป็นภาวะที่มีการอักเสบของเยื่อที่อยู่รอบสมองและไขสันหลังซึ่งเรียกรวมว่าเยื่อหุ้มสมอง การอักเสบนี้อาจเกิดจากการติดเชื้อไวรัส แบคทีเรีย หรือจุลชีพอื่นๆ และบางครั้งเกิดจากยาบางชนิด เป็นภาวะที่อาจเป็นอันตรายถึงชีวิตเนื่องจากเป็นการอักเสบที่อยู่ใกล้เนื้อสมองและไขสันหลัง ดังนั้นจึงเป็นภาวะฉุกเฉินทางการแพทย์');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('MERS','โรคเมอร์ส',null,'โรคติดเชื้อไวรัสโคโรน่าสายพันธุ์ใหม่ 2012 เป็นการติดเชื้อไวรัสในระบบหายใจจากเชื้อไวรัสสายพันธุ์ใหม่ MERS-CoV ซึ่งเป็นเบตาโคโรนาไวรัสที่เคยติดต่อในค้างคาว และยังตรวจพบภูมิคุ้มกันต่อไวรัสนี้ในอูฐ อย่างไรก็ดีแหล่งที่มาของเชื้อนี้ยังไม่ชัดเจน');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Salmonella','โรคติดเชื้อซาลโมเนลลา','Fluoroquinolone','เป็นกลุ่มของแบคทีเรียที่มักก่อให้เกิดโรคผ่านทางการรับประทานอาหารในสหรัฐอเมริกา การติดเชื้อแบคทีเรียชนิดนี้จะเรียกว่า Salmonellosis และสามารถติดได้ผ่านการรับประทานอาหารที่ปนเปื้อนเชื้อ เช่น เนื้อสัตว์ปีกดิบ ๆ ไข่ เนื้อวัว และผลไม้และผักที่ไม่ได้ล้างทำความสะอาด นอกจากนี้ สัตว์เลี้ยงบางชนิด โดยเฉพาะในกลุ่มสัตว์เลื้อยคลานเช่นงู เต่า หรือกิ้งก่าสามารถทำให้เกิดการแพร่เชื้อได้เช่นกัน');");
        db.execSQL("INSERT INTO "+ VIRUS +" (" + VIR_NAME_EN + ", " + VIR_NAME_TH + ", " + VIR_VACCINE    + ", "+ VIR_DATA + ") " +
                "VALUES ('Zika fever','โรคไข้ซิกา','NSAIDs','เป็นโรคติดเชื้ออย่างหนึ่งเกิดจากเชื้อไวรัสซิกา ผู้ป่วยส่วนใหญ่ไม่มีอาการ หรือมีอาการเล็กน้อยคล้ายกับไข้เดงกีอาการมักคงอยู่ไม่เกินเจ็ดวัน โดยอาการเหล่านี้เช่น ไข้ ตาแดง ปวดข้อ ปวดหัว ผื่นแดง เป็นต้นยังไม่มีรายงานว่ามีผู้ป่วยเสียชีวิตจากโรคนี้ ภาวะนี้สัมพันธ์กับการเกิดกลุ่มอาการกิลแลงบาร์เรอีกด้วย ไข้ซิกาติดต่อผ่านทางการถูกยุง Aedes เช่น ยุงลาย กัด เป็นส่วนใหญ่ ');");



        //BacTable
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Cancer of stomach','โรคมะเร็งกระเพราะอาหาร',null,' คือ เซลล์เนื้อร้ายหรือมะเร็งที่เกิดขึ้นที่บริเวณเยื่อบุผิวภายในกระเพาะอาหาร โดยเกิดจากการที่เซลล์เยื่อบุกระเพาะอาหารมีการแบ่งจำนวนมากขึ้นอย่างผิดปกติ ทำให้เกิดเป็นมะเร็งขึ้นมา สามารถเกิดได้กับทุกส่วนของกระเพาะอาหาร และสามารถแพร่กระจายไปยังอวัยวะรอบ ๆ กระเพาะอาหารได้ เช่น ตับอ่อน หลอดอาหาร ลำไส้ ปอด และรังไข่ นอกจากนี้เซลล์มะเร็งยังแพร่กระจายไปยังอวัยวะอื่น ๆ ผ่านทางต่อมน้ำเหลือง หรือทางกระแสเลือดได้ด้วย');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Meiningococcal Disease','โรคไข้กาฬหลังแอ่น','Menactra®','คือกลุ่มของโรคติดเชื้อ ที่เกิดจากการติดเชื้อแบคทีเรียสายพันธุ์ Neisseria meningitidis (อีกชื่อว่า เมนิงโกค็อกคัส ซึ่งเป็นโรคที่หากไม่ได้รับการรักษาที่เหมาะสมจะมีอัตราการเสียชีวิตสูงมาก แม้เชื้อนี้จะพบเป็นสาเหตุของโรคเยื่อหุ้มสมองอักเสบได้บ่อย แต่การติดเชื้อนี้เข้าสู่กระแสเลือดเป็นภาวะที่มีอันตรายกว่ามาก โรคเยื่อหุ้มสมองอักเสบจากเชื้อเมนิงโกค็อกคัส และโรคติดเชื้อเมนิงโกค็อกคัสเข้ากระแสเลือด เป็นสาเหตุของการเจ็บป่วย พิการ และเสียชีวิต ที่สำคัญ ทั้งในประเทศที่พัฒนาแล้วและกำลังพัฒนาทั่วโลก');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Pertussis Whooping Cough','โรคไอกรน','DTap',' เป็นโรคติดเชื้อแบคทีเรียที่ติดต่อได้ง่ายมากโรคหนึ่ง อาการแรกเริ่มมักคล้ายคลึงกับหวัด โดยผู้ป่วยจะมีไข้ น้ำมูกไหล และไอเล็กน้อย จากนั้นจึงมีอาการไอรุนแรงต่อเนื่องหลายสัปดาห์ และมีไอเสียงสูงหรือหายใจเฮือกขณะจะมีอาการไอ อาการไอในระยะนี้อาจเป็นต่อเนื่องได้ถึง 10 สัปดาห์หรือมากกว่า บางครั้งจึงเรียกโรคนี้ว่า โรคไอ 100 วัน ผู้ป่วยอาจมีอาการไอรุนแรงมากจนอาเจียน ซี่โครงหัก หรืออ่อนเพลียอย่างมากจากการไอได้ ผู้ป่วยเด็กอายุน้อยกว่า 1 ปีอาจมีอาการไอเพียงเล็กน้อยหรือไม่ไอเลย แต่มีอาการหยุดหายใจชั่วขณะแทน');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Leptospirosis','โรคฉี่หนู',null,' เป็นโรครับจากสัตว์ชนิดหนึ่ง สามารถติดโรคได้ในสัตว์หลายชนิด เช่น สุนัข หนู โค กระบือ สุกร แพะ แกะ สัตว์เลี้ยงในบ้าน เป็นต้น แต่พบมากในหนู ซึ่งเป็นแหล่งรังโรค ส่วนมากสัตว์ที่ไวต่อการรับเชื้อมักจะเป็นสัตว์เลี้ยงลูกด้วยนมที่มีอายุน้อย หรือลูกสัตว์ที่ไม่เคยได้รับภูมิคุ้มกันจากแม่มาก่อน มักจะพบการระบาดในเดือนตุลาคม และพฤศจิกายน เนื่องจากเป็นฤดูฝนต่อหนาว มีน้ำขัง');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Cholera','โรคอหิวาตกโนค','Dukoral®','โรคระบาดชนิดหนึ่ง เกิดจากการติดเชื้อแบคทีเรีย Vibrio cholerae ที่ลำไส้เล็ก ผู้ป่วยจะมีอาการท้องร่วงเป็นน้ำและอาเจียนเป็นหลัก ร่างกายจะขับน้ำออกมาเป็นจำนวนมาก ในผู้ป่วยรุนแรงอาจทำให้มีผิวสีออกเทา-น้ำเงินได้ การแพร่เชื้อเกิดขึ้นจากการดื่มน้ำหรือกินอาหารที่ปนเปื้อนอุจจาระของผู้ติดเชื้อเป็นหลัก ซึ่งผู้นั้นแม้ไม่มีอาการก็สามารถแพร่เชื้อได้ ความรุนแรงของอาการท้องร่วงและอาเจียนสามารถนำไปสู่ภาวะขาดน้ำและเสียสมดุลเกลือแร่อย่างรวดเร็ว กระทั่งเสียชีวิตในบางราย');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Pelvic Inflamatory Disease','โรคอุ้งเชิงกรานอักเสบ',null,'การติดเชื้อบริเวณระบบสืบพันธุ์ในเพศหญิง บริเวณมดลูก ปีกมดลูก และท่อนำไข่ ซึ่งการติดเชื้อนั้นอาจเกิดจากหลายสาเหตุ แต่ส่วนใหญ่มักเกิดจากโรคติดต่อทางเพศสัมพันธ์ เช่น หนองในแท้ หรือหนองในเทียม ซึ่งมักเกิดบริเวณช่องคลอดและปากมดลูก หากไม่ทำการรักษาก็อาจทำให้เชื้อแพร่กระจายไปบริเวณอื่นในระบบสืบพันธุ์ได้ โดยโรคนี้มักเกิดในหญิงวัยเจริญพันธุ์ อายุประมาณ 25 ปี หรือน้อยกว่านั้น');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Scabies','โรคหิด','Nix',' เป็นโรคผิวหนังอักเสบที่เกิดจาก ตัวหิด ซึ่งเป็นสัตว์ขาปล้องประเภทไรชนิดหนึ่งที่เป็นปรสิต และต้องอาศัยอยู่บนร่างกายของคน โดยดำรงชีวิตอยู่บนผิวหนังของคนและกินเซลล์ผิวหนังเป็นอาหาร และเป็นตัวก่อโรค โดยผู้ป่วยจะมีอาการหลักสำคัญ คือ คันและมีผื่นตามผิวหนัง โรคนี้สามารถติดต่อได้โดยการอยู่ใกล้ชิดและสัมผัสผิวหนังของผู้ที่เป็นหิด ซึ่งรวมถึงการมีเพศสัมพันธ์');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Tuberculosis','วัณโรค','BCG VACCINE',' เป็นโรคติดเชื้อที่พบบ่อย และถึงแก่ชีวิตของผู้ป่วยในหลายกรณี ที่เกิดจากไมโคแบคทีเรียหลายสายพันธุ์ ตามปกติคือ Mycobacterium tuberculosis วัณโรคโดยปกติก่อให้เกิดอาการป่วยที่ปอด แต่ยังสามารถส่งผลกระทบต่อส่วนอื่นของร่างกายได้ วัณโรคแพร่ผ่านอากาศเมื่อผู้ที่มีการติดเชื้อ MTB มีฤทธิ์ไอ จาม หรือส่งผ่านน้ำลายผ่านอากาศ การติดเชื้อในมนุษย์ส่วนมากส่งผลให้เกิดไร้อาการโรค การติดเชื้อแฝง และราวหนึ่งในสิบของการติดเชื้อแฝงท้ายที่สุดพัฒนาไปเป็นโรคมีฤทธิ์ ซึ่ง หากไม่ได้รับการรักษา ทำให้ผู้ติดเชื้อเสียชีวิตมากกว่า 50%');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Tetanus','โรคบาดทะยัก','Tenivac ®','เป็นโรคติดเชื้ออย่างหนึ่ง ผู้ป่วยจะมีอาการเด่นคืออาการกล้ามเนื้อเกร็ง ส่วนใหญ่การเกร็งจะเริ่มต้นที่กล้ามเนื้อกราม จากนั้นจึงลุกลามไปยังกล้ามเนื้อส่วนอื่นๆ การเกร็งแต่ละครั้งมักเป็นอยู่ไม่กี่นาที และเกิดขึ้นซ้ำๆ เป็นเวลา 3-4 สัปดาห์ การเกร็งอาจมีความรุนแรงมากจนทำให้กระดูกหักได้ อาการอื่นที่อาจพบร่วมได้แก่ ไข้ เหงื่อออก ปวดศีรษะ กลืนลำบาก ความดันเลือดสูง และหัวใจเต้นเร็ว ผู้ป่วยส่วนใหญ่เริ่มมีอาการหลังจากติดเชื้อเป็นเวลา 3-21 วัน การรักษาอาจใช้เวลาหลายเดือน ผู้ป่วยประมาณ 10% จะเสียชีวิต');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Pneumonia','โรคปอดบวม','PCV13','เป็นโรคของระบบหายใจอย่างหนึ่งซึ่งมีการอักเสบของปอด โดยเฉพาะของถุงลม ทำให้มีไข้ มีอาการทางปอด มีการสูญเสียของพื้นที่แลกเปลี่ยนก๊าซ ซึ่งเห็นได้จากการเอกซเรย์ปอด ส่วนใหญ่เกิดจากการติดเชื้อ เช่น การติดเชื้อแบคทีเรีย เชื้อไวรัส เชื้อรา หรือพยาธิ เชื้อแบคทีเรียชื่อ นิวโมคอคคัส  เป็นสาเหตุหลัก แต่ก็อาจเกิดจากสาเหตุอื่นๆ เช่นได้รับสารเคมีหรือการกระทบกระเทีอนทางกายภาพได้เช่นกัน');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('MSRA','โรคดื้อยา',null,' เป็นการติดเชื้อ Staph ชนิดหนึ่งที่มีการดื้อต่อยาปฏิชีวนะที่มักใช้ในการรักษาการติดเชื้อ Staph ทั่วไป เมื่อแบคทีเรียเกิดการดื้อยา จะทำให้การกำจัดเชื้อเป็นไปได้ยากขึ้นและใช้เวลานานขึ้นในการฟื้นตัวจากการติดเชื้อ เชื้อ Staphylococcus มีมากกว่า 30 สายพันธุ์แต่สายพันธุ์ที่พบได้บ่อยที่สุดคือ Staphylococcus aureus');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Chlamydia','โรคคลามายเดีย',null,' เป็นโรคติดต่อทางเพศสัมพันธ์ที่เกิดจากการติดเชื้อแบคทีเรียชื่อ คลามายเดีย แทรโคมาทิส (Chlamydia trachomatis) เป็นโรคติดต่อทางเพศสัมพันธ์ที่เกิดได้บ่อยที่สุดโรคหนึ่งในสหรัฐอเมริกา การติดเชื้อแบคทีเรียดังกล่าว จะเกิดบริเวณเซลล์เยื่อบุผิว (Epithelial cells) ซึ่งหมายถึง เซลล์ที่บุบริเวณผิวนอกของร่างกาย และผิวภายในของอวัยวะกลวง รวมถึงต่อมต่าง ๆ ในร่างกาย');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Giardiasis','โรคเจียอาร์ไดอาซิส', 'Metronidazole',' คือโรคที่เกิดในผู้ติดเชื้อปรสิตชนิด Giardia lamblia ผู้ติดเชื้อหลายรายไม่แสดงอาการเนื่องมาจากมีภูมิคุ้มกันที่ดี แต่ในผู้ติดเชื้อบางรายที่มีความไวต่อเชื้อมากกว่าผู้อื่น อาจเกิดอาการท้องเสียทำให้เกิดอาการขาดน้ำ และลำไส้มีการผลิตเมือกออกมามาก มีอาการปวดท้อง ผายลมบ่อย และน้ำหนักลด อุจจาระมีไขมันมากแต่ไม่มีเลือด เนื่องจากปรสิตจะไปรบกวนการดูดซึมไขมันและสารอาหารของลำไส้ ซึ่งเป็นการเริ่มต้นของโรค ถ้าถุงน้ำดีมีการติดเชื้อจะทำให้เกิดอาการตัวเหลืองตาเหลืองและปวดท้อง มีรายงานว่า lamblia ทำให้เกิดโรคลำไส้อักเสบ โรคนี้ไม่ทำให้ผู้ติดเชื้อเสียชีวิตแต่จะรบกวนไม่ให้ผู้ติดเชื้ออยู่ได้อย่างปกติสุข ');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Gonorrhea','โรคหนองในแท้','Ceftriaxone','เป็นโรคติดต่อทางเพศสัมพันธ์ที่พบได้บ่อย เกิดจากการติดเชื้อแบคทีเรีย Neisseria gonorrhoeae เชื้อนี้จะทำให้เกิดโรคเฉพาะเยื่อเมือก mucous membrance เช่น เยื่อเมือกในท่อปัสสาวะ ช่องคลอด ปากมดลูก และเยื่อบุมดลูก, ท่อรังไข่, ทวารหนัก, คอ และเยื่อบุตา อาการที่พบได้บ่อยสำหรับผู้ชายคือ ปวดแสบขณะปัสสาวะ และมีหนองสีเหลือง สำหรับผู้หญิง ครึ่งหนึ่งมักไม่มีอาการ หรือ มีตกขาว หรือเลือดผิดปกติ และปวดอุ้งเชิงกราน');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Acute purulent meningitis','โรคเยื่อหุ้มสมองอักเสบเฉียบพลันชนิดมีหนองจากเชื้อแบคทีเรีย','Phenobarbital','แบคทีเรียที่ทำให้เกิดเยื่อหุ้มสมองอักเสบนั้นแตกต่างออกไปตามช่วงอายุ ในทารกแรกเกิดจนถึงอายุ 3 ปี เชื้อส่วนใหญ่เป็น สเตร็ปโตคอคคัส กลุ่ม B  และเชื้อในทางเดินอาหาร เช่น เอสเคอริเชีย โคไล (ชนิดที่มีแอนติเจน K1) ลิสทีเรีย โมโนซัยโตจีเนส (ซีโรทัยป์ IVb) ซึ่งอาจทำให้เกิดโรคในทารกแรกเกิดและเกิดการระบาดได้ เด็กโตขึ้นมาส่วนใหญ่ติดเชื้อ ไนซีเรีย เมนิงไจไทดิส (เมนิงโกคอคคัส), สเตรปโตคอคคัส นิวโมนิอี และฮีโมฟิลุส อินฟลูเอนเซ เป็นสาเหตุของเยื่อหุ้มสมองอักเสบจากแบคทีเรียรวมกัน 80% ');");
        db.execSQL("INSERT INTO "+ BACTERIA +" (" + BAC_NAME_EN + ", " + BAC_NAME_TH + ", " + BAC_VACCINE    + ", "+ BAC_DATA + ") " +
                "VALUES ('Trichomonas Vaginalis','โรคติดเชื้อทริโคโมแนส',null,'เป็นโรคติดต่อทางเพศสัมพันธ์ที่รักษาได้ ซึ่งพบมากที่สุดในผู้หญิง มีผู้ติดเชื้อประมาณ 3.7 ล้านคนในประเทศสหรัฐอเมริกาและการติดเชื้อมักเกิดกับผู้หญิงมากกว่าผู้ชาย เนื่องจากการติดเชื้อมีสาเหตุมาจากปรสิต จึงทำให้เกิดตกขาวมีกลิ่นเหม็นและเจ็บเวลาปัสสาวะได้ หากผู้ชายติดเชื้อทริโคโมแนสจะไม่แสดงอาการ จากข้อเท็จจริงนั้นพบว่า ผู้คนทั้งหมดที่ติดเชื้อทริโคโมแนส มีเพียง 30% เท่านั้นที่แสดงอาการ');");


        //Vaccine Table
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Imovax®','Rabies','1980','Manufactorer: sanofi','Vaccine Type: Inactivated','คำอธิบาย : ทุกช่วงอายุ');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Dengvaxia®','Dengue','2015','Manufactorer: sanofi','Vaccine Type: live attenuated','คำอธิบาย : อายุมากกว่า 9 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('JESPECT®','Japanese encephalitis','2009','Manufactorer: valneva','Vaccine Type: Inactivated','คำอธิบาย : อายุมากกว่า 2 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('HSV-2','Herpes simplex','1993','Manufactorer: Burke','Vaccine Type: Antibody','คำอธิบาย : ทุกช่วงอายุ');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Zostavax','Herpes Zoster','2006','Manufactorer: Merck','Vaccine Type:Live Attenuated','คำอธิบาย : อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('twinrix(GSK)','Cirrhosis','1997','Manufactorer: GSK Biologicals','Vaccine Type:Inactivated','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Tamiflu','Avian influenza','1999','Manufactorer: Gilead','Vaccine Type: antiviral medication','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Nix','scabies','1973','Manufactorer: Bristol-Myers Squibb','Vaccine Type: Crotamiton','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('SalmAbic Infantis ','Salmonellosis','2011','Manufactorer: Phibro Vaccines','Vaccine Type: Inactivated','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('ZPIV','Zika','2016','Manufactorer: NIAID','Vaccine Type: Inactivated phase II','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Menactra®','Meningococcal Disease','2005','Manufactorer: Sanofi','Vaccine Type: Conjugate','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Dtap and Tdap',' Whooping Cough','1949','Manufactorer: Sanofi','Vaccine Type: Inactivated','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Dukoral®','Cholera','2010','Manufactorer: SBL Vaccin AB','Vaccine Type: Inactivated','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('BCG Vaccine®','Tuberculosis','1921','Manufactorer: Sanofi','Vaccine Type: Live bacteria','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('PCV13','Pneumonia','2010','Manufactorer: Pfizer','Vaccine Type: Conjugate','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Metronidazole','Giardiasis','1960','Manufactorer: Pfizer','Vaccine Type: Antibiotic','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Ceftriaxone','Gonorrhea','1980','Manufactorer: Hoffmann-La Roche','Vaccine Type: Antibiotic','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");
        db.execSQL("INSERT INTO "+ VACCINE +" (" + VAC_NAME + ", " + VAC_PRODUCT_DIS + ", " + VAC_YEAR_PD    + ", " + VAC_MANUFACTURER + ", " + VAC_TYPE +", " + VAC_DESCRIPTION+ ") " +
                "VALUES ('Phenobarbital','Acute purulent Meningitis','1912','Manufactorer: Bayer AG','Vaccine Type: Antibiotic','คำอธิบาย : เด็กอายุ 2 ปีขึ้นไปและผู้ใหญ่อายุ 50 ปีขึ้นไป');");

        // get Data from SQLite

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ VIRUS);
        db.execSQL("DROP TABLE IF EXISTS "+ BACTERIA);
        db.execSQL("DROP TABLE IF EXISTS "+ VACCINE);
        onCreate(db);
    }
}


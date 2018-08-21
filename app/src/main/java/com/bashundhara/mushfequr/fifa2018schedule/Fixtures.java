package com.bashundhara.mushfequr.fifa2018schedule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class Fixtures {

    HashMap<String,String> MatchData = new HashMap<>();
    ArrayList<HashMap<String,String>> Matches_Files= new ArrayList<>();



    public  void Set_Up_Matches()
    {
        MatchData.put("COUNT","1");
        MatchData.put("DATE","14/06/2018");
        MatchData.put("TEAM_1_NAME","RUSSIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/russia/russia_640.png");
        MatchData.put("TEAM_2_NAME","SAUDI ARABIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/saudi_arabia/saudi_arabia_640.png");
        MatchData.put("START_TIME"," 14th June 2018,09:00pm Luzhniki Stadium");

        Matches_Files.add(MatchData);
        MatchData= new HashMap<>();

        MatchData.put("COUNT","2");
        MatchData.put("DATE","15/06/2018");
        MatchData.put("TEAM_1_NAME","EGYPT");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/egypt/egypt_640.png");
        MatchData.put("TEAM_2_NAME","URUGUAY");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/uruguay/uruguay_640.png");
        MatchData.put("START_TIME"," 15th June 2018,06:00pm Ektarinburg Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","3");
        MatchData.put("DATE","15/06/2018");
        MatchData.put("TEAM_1_NAME","MOROCCO");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/morocco/morocco_640.png");
        MatchData.put("TEAM_2_NAME","IRAN");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/iran/iran_640.png");
        MatchData.put("START_TIME"," 15th June 2018,09:00pm Saint Petersburg Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","4");
        MatchData.put("DATE","15/06/2018");
        MatchData.put("TEAM_1_NAME","PORTUGAL");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/glossy_round_icon/portugal/portugal_640.png");
        MatchData.put("TEAM_2_NAME","SPAIN");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/spain/spain_640.png");
        MatchData.put("START_TIME"," 16th June 2018,12:00am Fisht Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","5");
        MatchData.put("DATE","16/06/2018");
        MatchData.put("TEAM_1_NAME","FRANCE");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/france/france_640.png");
        MatchData.put("TEAM_2_NAME","AUSTRALIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/australia/australia_640.png");
        MatchData.put("START_TIME"," 16th June 2018,04:00pm Kazan Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();



        MatchData.put("COUNT","6");
        MatchData.put("DATE","16/06/2018");
        MatchData.put("TEAM_1_NAME","ARGENTINA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/argentina/argentina_640.png");
        MatchData.put("TEAM_2_NAME","ICELAND");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/iceland/iceland_640.png");
        MatchData.put("START_TIME"," 16th June 2018,07:00pm Spartak Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","7");
        MatchData.put("DATE","16/06/2018");
        MatchData.put("TEAM_1_NAME","PERU");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/peru/peru_640.png");
        MatchData.put("TEAM_2_NAME","DENMARK");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/denmark/denmark_640.png");
        MatchData.put("START_TIME"," 16th June 2018,10:00pm Mordovia Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","8");
        MatchData.put("DATE","17/06/2018");
        MatchData.put("TEAM_1_NAME","CROATIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/croatia/croatia_640.png");
        MatchData.put("TEAM_2_NAME","NIGERIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/nigeria/nigeria_640.png");
        MatchData.put("START_TIME"," 17th June 2018,01:00am Kalningrad Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","9");
        MatchData.put("DATE","17/06/2018");
        MatchData.put("TEAM_1_NAME","COSTA RICA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/costa_rica/costa_rica_640.png");
        MatchData.put("TEAM_2_NAME","SERBIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/serbia/serbia_640.png");
        MatchData.put("START_TIME"," 17th June 2018,06:00pm Samara Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","10");
        MatchData.put("DATE","17/06/2018");
        MatchData.put("TEAM_1_NAME","GERMANY");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/germany/germany_640.png");
        MatchData.put("TEAM_2_NAME","MEXICO");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME"," 17th June 2018,09:00pm     Luzhniki Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","11");
        MatchData.put("DATE","17/06/2018");
        MatchData.put("TEAM_1_NAME","BRAZIL");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/brazil/brazil_640.png");
        MatchData.put("TEAM_2_NAME","SWITZERLAND");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/switzerland/switzerland_640.png");
        MatchData.put("START_TIME","18th June 2018,12:00am Rostov Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","12");
        MatchData.put("DATE","18/06/2018");
        MatchData.put("TEAM_1_NAME","SWEDEN");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/sweden/sweden_640.png");
        MatchData.put("TEAM_2_NAME","SOUTH KOREA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("START_TIME","18th June 2018,06:00pm Nizhny Novgorod Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","13");
        MatchData.put("DATE","18/06/2018");
        MatchData.put("TEAM_1_NAME","BELGIUM");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/belgium/belgium_640.png");
        MatchData.put("TEAM_2_NAME","PANAMA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/panama/panama_640.png");
        MatchData.put("START_TIME","18th June 2018,09:00pm Fisht Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","14");
        MatchData.put("DATE","18/06/2018");
        MatchData.put("TEAM_1_NAME","TUNISIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/tunisia/tunisia_640.png");
        MatchData.put("TEAM_2_NAME","ENGLAND");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/england/england_640.png");
        MatchData.put("START_TIME","19th June 2018,12:00am Volgograd Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","15");
        MatchData.put("DATE","19/06/2018");
        MatchData.put("TEAM_1_NAME","COLOMBIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/colombia/colombia_640.png");
        MatchData.put("TEAM_2_NAME","JAPAN");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/japan/japan_640.png");
        MatchData.put("START_TIME","19th June 2018,06:00pm Mordovia Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();


        MatchData.put("COUNT","16");
        MatchData.put("DATE","19/06/2018");
        MatchData.put("TEAM_1_NAME","POLAND");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/poland/poland_640.png");
        MatchData.put("TEAM_2_NAME","SENEGAL");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/senegal/senegal_640.png");
        MatchData.put("START_TIME","19th June 2018,09:00pm Spartak Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","17");
        MatchData.put("DATE","19/06/2018");
        MatchData.put("TEAM_1_NAME","RUSSIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/russia/russia_640.png");
        MatchData.put("TEAM_2_NAME","EGYPT");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/egypt/egypt_640.png");
        MatchData.put("START_TIME","20th June 2018,12:00am Saint Petersburg Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","18");
        MatchData.put("DATE","20/06/2018");
        MatchData.put("TEAM_1_NAME","PORTUGAL");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/portugal/portugal_640.png");
        MatchData.put("TEAM_2_NAME","MOROCCO");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/morocco/morocco_640.png");
        MatchData.put("START_TIME","20th June 2018,06:00pm Luzhniki Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","19");
        MatchData.put("DATE","20/06/2018");
        MatchData.put("TEAM_1_NAME","URUGUAY");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/uruguay/uruguay_640.png");
        MatchData.put("TEAM_2_NAME","SAUDI ARABIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/saudi_arabia/saudi_arabia_640.png");
        MatchData.put("START_TIME","20th June 2018,09:00pm Rostov Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","20");
        MatchData.put("DATE","20/06/2018");
        MatchData.put("TEAM_1_NAME","IRAN");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/iran/iran_640.png");
        MatchData.put("TEAM_2_NAME","SPAIN");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/spain/spain_640.png");
        MatchData.put("START_TIME","21st June 2018,12:00am Kazan Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","21");
        MatchData.put("DATE","21/06/2018");
        MatchData.put("TEAM_1_NAME","DENMARK");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/denmark/denmark_640.png");
        MatchData.put("TEAM_2_NAME","AUSTRALIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/australia/australia_640.png");
        MatchData.put("START_TIME","21st June 2018,06:00pm Samara Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","22");
        MatchData.put("DATE","21/06/2018");
        MatchData.put("TEAM_1_NAME","FRANCE");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/france/france_640.png");
        MatchData.put("TEAM_2_NAME","PERU");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/peru/peru_640.png");
        MatchData.put("START_TIME","21st June 2018,09:00pm Ekaterinburg Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","23");
        MatchData.put("DATE","21/06/2018");
        MatchData.put("TEAM_1_NAME","ARGENTINA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/argentina/argentina_640.png");
        MatchData.put("TEAM_2_NAME","CROATIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/croatia/croatia_640.png");
        MatchData.put("START_TIME","22nd June 2018,12:00am  Nizhny Novgorod Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","24");
        MatchData.put("DATE","22/06/2018");
        MatchData.put("TEAM_1_NAME","BRAZIL");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/brazil/brazil_640.png");
        MatchData.put("TEAM_2_NAME","COSTA RICA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/costa_rica/costa_rica_640.png");
        MatchData.put("START_TIME","22nd June 2018,06:00pm Saint Petersburg Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","25");
        MatchData.put("DATE","22/06/2018");
        MatchData.put("TEAM_1_NAME","NIGERIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/nigeria/nigeria_640.png");
        MatchData.put("TEAM_2_NAME","ICELAND");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/iceland/iceland_640.png");
        MatchData.put("START_TIME"," 22nd June 2018,09:00pm Volgograd Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","26");
        MatchData.put("DATE","22/06/2018");
        MatchData.put("TEAM_1_NAME","SERBIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/serbia/serbia_640.png");
        MatchData.put("TEAM_2_NAME","SWITZERLAND");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/switzerland/switzerland_640.png");
        MatchData.put("START_TIME","23rd June 2018,12:00am Kaliningrad Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","27");
        MatchData.put("DATE","23/06/2018");
        MatchData.put("TEAM_1_NAME","BELGIUM");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/belgium/belgium_640.png");
        MatchData.put("TEAM_2_NAME","TUNISIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/tunisia/tunisia_640.png");
        MatchData.put("START_TIME","23rd June 2018,06:00pm Spartak Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","28");
        MatchData.put("DATE","23/06/2018");
        MatchData.put("TEAM_1_NAME","SOUTH KOREA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","MEXICO");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","23rd June 2018,09:00pm Rostov Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","29");
        MatchData.put("DATE","23/06/2018");
        MatchData.put("TEAM_1_NAME","GERMANY");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/germany/germany_640.png");
        MatchData.put("TEAM_2_NAME","SWEDEN");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/sweden/sweden_640.png");
        MatchData.put("START_TIME","24th June 2018,12:00am Fisht Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","30");
        MatchData.put("DATE","24/06/2018");
        MatchData.put("TEAM_1_NAME","ENGLAND");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/england/england_640.png");
        MatchData.put("TEAM_2_NAME","PANAMA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/panama/panama_640.png");
        MatchData.put("START_TIME","24th June 2018,06:00pm Nizhny Novgrod Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","31");
        MatchData.put("DATE","24/06/2018");
        MatchData.put("TEAM_1_NAME","JAPAN");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/japan/japan_640.png");
        MatchData.put("TEAM_2_NAME","SENEGAL");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/senegal/senegal_640.png");
        MatchData.put("START_TIME","24th June 2018,09:00pm Ekaterinburg Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","32");
        MatchData.put("DATE","24/06/2018");
        MatchData.put("TEAM_1_NAME","POLAND");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/poland/poland_640.png");
        MatchData.put("TEAM_2_NAME","COLOMBIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/colombia/colombia_640.png");
        MatchData.put("START_TIME","25th June 2018,12:00am Kazan Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        //==========================================================================================
        //GAMEDAY THREE DATA
        //==========================================================================================

        MatchData.put("COUNT","33");
        MatchData.put("DATE","25/06/2018");
        MatchData.put("TEAM_1_NAME","SAUDI ARABIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/saudi_arabia/saudi_arabia_640.png");
        MatchData.put("TEAM_2_NAME","EGYPT");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/egypt/egypt_640.png");
        MatchData.put("START_TIME","25th June 2018,08:00pm Volgograd Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","34");
        MatchData.put("DATE","25/06/2018");
        MatchData.put("TEAM_1_NAME","URUGUAY");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/uruguay/uruguay_640.png");
        MatchData.put("TEAM_2_NAME","RUSSIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/russia/russia_640.png");
        MatchData.put("START_TIME"," 25th June 2018,08:00pm Samara Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","35");
        MatchData.put("DATE","25/06/2018");
        MatchData.put("TEAM_1_NAME","IRAN");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/iran/iran_640.png");
        MatchData.put("TEAM_2_NAME","PORTUGAL");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/portugal/portugal_640.png");
        MatchData.put("START_TIME","26th June 2018,12:00am Mordovia Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","36");
        MatchData.put("DATE","25/06/2018");
        MatchData.put("TEAM_1_NAME","SPAIN");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/spain/spain_640.png");
        MatchData.put("TEAM_2_NAME","MOROCCO");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/morocco/morocco_640.png");
        MatchData.put("START_TIME","26th June 2018,12:00am Kalningrad Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","37");
        MatchData.put("DATE","26/06/2018");
        MatchData.put("TEAM_1_NAME","AUSTRALIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/australia/australia_640.png");
        MatchData.put("TEAM_2_NAME","PERU");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/peru/peru_640.png");
        MatchData.put("START_TIME","26th June 2018,08:00pm Fisht Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","38");
        MatchData.put("DATE","26/06/2018");
        MatchData.put("TEAM_1_NAME","DENMARK");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/denmark/denmark_640.png");
        MatchData.put("TEAM_2_NAME","FRANCE");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/france/france_640.png");
        MatchData.put("START_TIME","26th June 2018,08:00pm Luzhniki Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","39");
        MatchData.put("DATE","26/06/2018");
        MatchData.put("TEAM_1_NAME","NIGERIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/nigeria/nigeria_640.png");
        MatchData.put("TEAM_2_NAME","ARGENTINA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/argentina/argentina_640.png");
        MatchData.put("START_TIME","27th June 2018,12:00am Saint Petersburg Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","40");
        MatchData.put("DATE","26/06/2018");
        MatchData.put("TEAM_1_NAME","ICELAND");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/iceland/iceland_640.png");
        MatchData.put("TEAM_2_NAME","CROATIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/croatia/croatia_640.png");
        MatchData.put("START_TIME","27th June 2018,12:00am Rostov Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","41");
        MatchData.put("DATE","27/06/2018");
        MatchData.put("TEAM_1_NAME","SOUTH KOREA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","GERMANY");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/germany/germany_640.png");
        MatchData.put("START_TIME","27th June 2018,08:00pm Kazan Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","42");
        MatchData.put("DATE","27/06/2018");
        MatchData.put("TEAM_1_NAME","MEXICO");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("TEAM_2_NAME","SWEDEN");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/sweden/sweden_640.png");
        MatchData.put("START_TIME","27th June 2018,08:00pm Ekaterinburg Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
        MatchData.put("COUNT","43");
        MatchData.put("DATE","27/06/2018");
        MatchData.put("TEAM_1_NAME","SWITZERLAND");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/switzerland/switzerland_640.png");
        MatchData.put("TEAM_2_NAME","COSTA RICA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","28th June 2018,12:00am Nizhny Novgorod Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","44");
        MatchData.put("DATE","27/06/2018");
        MatchData.put("TEAM_1_NAME","SERBIA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/serbia/serbia_640.png");
        MatchData.put("TEAM_2_NAME","BRAZIL");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/switzerland/switzerland_640.png");
        MatchData.put("START_TIME","28th June 2018,12:00am Spartak Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();


        MatchData.put("COUNT","45");
        MatchData.put("DATE","28/06/2018");
        MatchData.put("TEAM_1_NAME","SENEGAL");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/senegal/senegal_640.png");
        MatchData.put("TEAM_2_NAME","COLOMBIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/colombia/colombia_640.png");
        MatchData.put("START_TIME","28th June 2018,08:00pm Samara Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","46");
        MatchData.put("DATE","28/06/2018");
        MatchData.put("TEAM_1_NAME","JAPAN");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/japan/japan_640.png");
        MatchData.put("TEAM_2_NAME","POLAND");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/poland/poland_640.png");
        MatchData.put("START_TIME","28th June 2018,08:00pm Volgograd Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","47");
        MatchData.put("DATE","28/06/2018");
        MatchData.put("TEAM_1_NAME","ENGLAND");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/england/england_640.png");
        MatchData.put("TEAM_2_NAME","BELGIUM");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/belgium/belgium_640.png");
        MatchData.put("START_TIME","29th June 2018,12:00am Kaliningrad Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","48");
        MatchData.put("DATE","28/06/2018");
        MatchData.put("TEAM_1_NAME","PANAMA");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/panama/panama_640.png");
        MatchData.put("TEAM_2_NAME","BELGIUM/TUNISIA");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/tunisia/tunisia_640.png");
        MatchData.put("START_TIME","29th June 2018,12:00am Mordovia Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();


        //=========================================================================================
        //KNOCK OFF STAGES
        //=========================================================================================
        MatchData.put("COUNT","49");
        MatchData.put("DATE","30/06/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","30th June 2018,08:00pm Kazan Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","50");
        MatchData.put("DATE","30/06/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","1st July 2018,12:00am Fisht Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
        MatchData.put("COUNT","51");
        MatchData.put("DATE","01/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","1st July 2018,08:00pm Luzhniki Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
        MatchData.put("COUNT","52");
        MatchData.put("DATE","01/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","2nd July 2018,12:00am Nizhny Novgorod Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
        MatchData.put("COUNT","53");
        MatchData.put("DATE","02/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","2nd July 2018,08:00pm Samara Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","54");
        MatchData.put("DATE","02/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","3rd July 2018,12:00am Rostov Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
        MatchData.put("COUNT","55");
        MatchData.put("DATE","03/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","3rd July 2018,08:00pm Saint Petersburg Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","56");
        MatchData.put("DATE","03/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","4th July 2018,12:00am Spartak Stadium");
        //==========================================================================================
        //QUATER FINALS
        //==========================================================================================

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
        MatchData.put("COUNT","57");
        MatchData.put("DATE","06/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","6th July 2018,08:00pm Nizhny Novgorod Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
        MatchData.put("COUNT","58");
        MatchData.put("DATE","06/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","7th July 2018,12:00am Kazan Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","59");
        MatchData.put("DATE","07/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","7th July 2018,08:00pm Samara Arena");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","60");
        MatchData.put("DATE","07/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","8th July 2018,12:00am Fisht Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();
    //=============================================================================================
       //SEMI FINALS
    //==============================================================================================

        MatchData.put("COUNT","61");
        MatchData.put("DATE","11/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","12th July 2018,12:00am Saint Petersburg Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","62");
        MatchData.put("DATE","12/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","13th July 2018,12:00am Luzhniki Stadium");

        Matches_Files.add(MatchData);

        MatchData=new HashMap<>();
        //===========================================================================================
        //FINALS
        //==========================================================================================
        MatchData.put("COUNT","63");
        MatchData.put("DATE","14/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","14th July 2018,08:00pm Saint Petersburg Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();

        MatchData.put("COUNT","64");
        MatchData.put("DATE","15/07/2018");
        MatchData.put("TEAM_1_NAME","TBD");
        MatchData.put("TEAM_1_IMAGE","http://img.freeflagicons.com/thumb/round_icon/korea_south/korea_south_640.png");
        MatchData.put("TEAM_2_NAME","TBD");
        MatchData.put("TEAM_2_IMAGE","http://img.freeflagicons.com/thumb/round_icon/mexico/mexico_640.png");
        MatchData.put("START_TIME","15th July 2018,09:00pm Luzhniki Stadium");

        Matches_Files.add(MatchData);
        MatchData=new HashMap<>();


    }

    public String Convert_List_to_Json() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String Fixtures_json=  gson.toJson(Matches_Files);

        return Fixtures_json;
    }


}

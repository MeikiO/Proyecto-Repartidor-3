drop database if exists springpruebas;
create database springpruebas;
use springpruebas;

#SET FOREIGN_KEY_CHECKS=0; #quitamos el chequeo de los foreign key para poder crear pedidos

select * from credencial;

select * from punto_reparto;



# ---------------------Poblacion------------------------------------
# Informacion aqui:  https://www.uncodigopostal.nom.es/espana/1/index.php
#---Guipuzkoa
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Abaltzisketa","Guipuzcoa","20269");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Aduna","Guipuzcoa","20150");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Aia","Guipuzcoa","20809");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Aizarnazabal","Guipuzcoa","20749");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Albiztur","Guipuzcoa","20495");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Alegia","Guipuzcoa","20260");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Alkiza","Guipuzcoa","20494");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Altzaga","Guipuzcoa","20248");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Altzo","Guipuzcoa","20268");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Amezketa","Guipuzcoa","20268");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Andoain","Guipuzcoa","20140");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Anoeta","Guipuzcoa","20270");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Antzuola","Guipuzcoa","20577");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arama","Guipuzcoa","20248");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Aretxabaleta","Guipuzcoa","20550");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("ArrasateoMondragon","Guipuzcoa","20500");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Asteasu","Guipuzcoa","20159");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Astigarraga","Guipuzcoa","20115");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ataun","Guipuzcoa","20211");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Azkoitia","Guipuzcoa","20720");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Azpeitia","Guipuzcoa","20730");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Baliarrain","Guipuzcoa","20259");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Beasain","Guipuzcoa","20200");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Beizama","Guipuzcoa","20739");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Belauntza","Guipuzcoa","20491");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Berastegi","Guipuzcoa","20492");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Bergara","Guipuzcoa","20570");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Berrobi","Guipuzcoa","20493");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Bidegoian","Guipuzcoa","20496");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Deba","Guipuzcoa","20820");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Donostia-San-Sebastian","Guipuzcoa","20018");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Eibar","Guipuzcoa","20600");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Elduain","Guipuzcoa","20493");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Elgeta","Guipuzcoa","20690");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Elgoibar","Guipuzcoa","20870");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Errenteria","Guipuzcoa","20100");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Errezil","Guipuzcoa","20737");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Eskoriatza","Guipuzcoa","20540");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ezkio-Itsaso","Guipuzcoa","20709");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gabiria","Guipuzcoa","20217");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gaintza","Guipuzcoa","20248");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gaztelu","Guipuzcoa","20491");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Getaria","Guipuzcoa","20808");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Hernani","Guipuzcoa","20120");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Hernialde","Guipuzcoa","20494");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Hondarribia","Guipuzcoa","20280");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ibarra","Guipuzcoa","20400");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Idiazabal","Guipuzcoa","20213");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ikaztegieta","Guipuzcoa","20267");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Irun","Guipuzcoa","20305");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Irura","Guipuzcoa","20271");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Itsasondo","Guipuzcoa","20249");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Larraul","Guipuzcoa","20159");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lasarte-Oria","Guipuzcoa","20160");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lazkao","Guipuzcoa","20210");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Leaburu","Guipuzcoa","20491");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Legazpi","Guipuzcoa","20230");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Legorreta","Guipuzcoa","20250");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Leintz-Gatzaga","Guipuzcoa","20530");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lezo","Guipuzcoa","20100");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lizartza","Guipuzcoa","20490");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mendaro","Guipuzcoa","20850");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mutiloa","Guipuzcoa","20214");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mutriku","Guipuzcoa","20830");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Oiartzun","Guipuzcoa","20180");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Olaberria","Guipuzcoa","20212");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Onati","Guipuzcoa","20560");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ordizia","Guipuzcoa","20240");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Orendain","Guipuzcoa","20269");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Orexa","Guipuzcoa","20490");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Orio","Guipuzcoa","20810");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ormaiztegi","Guipuzcoa","20216");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Pasaia","Guipuzcoa","20110");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Segura","Guipuzcoa","20214");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("SoraluzeoPlacencia-de-las-Arma","Guipuzcoa","20590");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Tolosa","Guipuzcoa","20400");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Urnieta","Guipuzcoa","20130");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Urretxu","Guipuzcoa","20700");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Usurbil","Guipuzcoa","20170");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Villabona","Guipuzcoa","20150");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zaldibia","Guipuzcoa","20247");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zarautz","Guipuzcoa","20800");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zegama","Guipuzcoa","20215");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zerain","Guipuzcoa","20214");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zestoa","Guipuzcoa","20740");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zizurkil","Guipuzcoa","20159");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zumaia","Guipuzcoa","20750");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zumarraga","Guipuzcoa","20700");

#---Araba
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Alegria-Dulantzi","Alava","1240");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Amurrio","Alava","1470");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Anana","Alava","1426");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Aramaio","Alava","1169");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arminon","Alava","1220");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arraia-Maeztu","Alava","1250");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arrazua-Ubarrundia","Alava","1520");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Artziniega","Alava","1474");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Asparrena","Alava","1250");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("AyalaoAiara","Alava","1476");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Banos-de-EbrooManueta","Alava","1307");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Barrundia","Alava","1206");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Berantevilla","Alava","1211");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Bernedo","Alava","1118");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("CampezooKanpezu","Alava","1110");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("ElburgooBurgelu","Alava","1192");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Elciego","Alava","1340");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("ElvillaroBilar","Alava","1309");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("ErriberagoitiaoRibera-Alta","Alava","1420");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("HaranaoValle-de-Arana","Alava","1117");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Iruna-OkaoIruna-de-Oca","Alava","1230");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Iruraiz-Gauna","Alava","1193");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Kripan","Alava","1308");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Kuartango","Alava","1430");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Labastida","Alava","1330");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lagran","Alava","1118");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Laguardia","Alava","1300");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("LanciegooLantziego","Alava","1308");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lantaron","Alava","1213");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lapuebla-de-Labarca","Alava","1306");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Legutiano","Alava","1170");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Leza","Alava","1309");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Llodio","Alava","1400");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Moreda-de-alava","Alava","1322");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Navaridas","Alava","1309");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Okondo","Alava","1409");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Oyon-Oion","Alava","1320");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Penacerrada-Urizaharra","Alava","1212");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ribera-BajaoErribera-Beitia","Alava","1213");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("SalvatierraoAgurain","Alava","1200");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Samaniego","Alava","1307");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("San-MillanoDonemiliaga","Alava","1208");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Urkabustaiz","Alava","1440");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Valdegovia","Alava","1426");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Villabuena-de-alavaoEskuernaga","Alava","1307");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Vitoria-Gasteiz","Alava","01015");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("YecoraoIekora","Alava","1322");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zalduondo","Alava","1208");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zambrana","Alava","1212");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zigoitia","Alava","1138");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zuia","Alava","1130");



#---Bizkaia
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Abadino","Vizcaya","48220");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Abanto-y-Ciervana-Abanto-Zierb","Vizcaya","48500");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ajangiz","Vizcaya","48320");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Alonsotegi","Vizcaya","48810");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Amorebieta-Etxano","Vizcaya","48340");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Amoroto","Vizcaya","48289");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arakaldo","Vizcaya","48498");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arantzazu","Vizcaya","48140");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Areatza","Vizcaya","48143");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arrankudiaga","Vizcaya","48498");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arratzu","Vizcaya","48383");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arrieta","Vizcaya","48114");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Arrigorriaga","Vizcaya","48480");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Artea","Vizcaya","48142");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Artzentales","Vizcaya","48879");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Atxondo","Vizcaya","48291");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Aulesti","Vizcaya","48380");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Bakio","Vizcaya","48130");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Balmaseda","Vizcaya","48800");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Barakaldo","Vizcaya","48900");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Barrika","Vizcaya","48650");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Basauri","Vizcaya","48970");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Bedia","Vizcaya","48390");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Berango","Vizcaya","48640");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Bermeo","Vizcaya","48370");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Berriatua","Vizcaya","48710");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Berriz","Vizcaya","48240");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Bilbao","Vizcaya","48001");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Busturia","Vizcaya","48350");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Derio","Vizcaya","48160");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Dima","Vizcaya","48141");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Durango","Vizcaya","48200");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ea","Vizcaya","48287");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Elantxobe","Vizcaya","48310");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Elorrio","Vizcaya","48230");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Erandio","Vizcaya","48950");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ereno","Vizcaya","48313");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ermua","Vizcaya","48260");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Errigoiti","Vizcaya","48309");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Etxebarri","Vizcaya","48450");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Etxebarria","Vizcaya","48277");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Forua","Vizcaya","48393");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Fruiz","Vizcaya","48116");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Galdakao","Vizcaya","48960");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Galdames","Vizcaya","48191");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gamiz-Fika","Vizcaya","48113");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Garai","Vizcaya","48200");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gatika","Vizcaya","48110");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gautegiz-Arteaga","Vizcaya","48314");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gernika-Lumo","Vizcaya","48300");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Getxo","Vizcaya","48930 al 48993");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gizaburuaga","Vizcaya","48289");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gordexola","Vizcaya","48192");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Gorliz","Vizcaya","48630");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Guenes","Vizcaya","48840");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ibarrangelu","Vizcaya","48311");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Igorre","Vizcaya","48140");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ispaster","Vizcaya","48288");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Iurreta","Vizcaya","48215");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Izurtza","Vizcaya","48213");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Karrantza-HaranaoValle-de-Carr","Vizcaya","48891");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Kortezubi","Vizcaya","48315");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lanestosa","Vizcaya","48895");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Larrabetzu","Vizcaya","48195");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Laukiz","Vizcaya","48111");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Leioa","Vizcaya","48940");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lekeitio","Vizcaya","48280");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lemoa","Vizcaya","48330");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lemoiz","Vizcaya","48620");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Lezama","Vizcaya","48196");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Loiu","Vizcaya","48180");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mallabia","Vizcaya","48269");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Manaria","Vizcaya","48212");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Markina-Xemein","Vizcaya","48270");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Maruri-Jatabe","Vizcaya","48112");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Menaka","Vizcaya","48120");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mendata","Vizcaya","48382");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mendexa","Vizcaya","48289");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Morga","Vizcaya","48115");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mundaka","Vizcaya","48360");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Mungia","Vizcaya","48100");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Munitibar-Arbatzegi-Gerrikaitz","Vizcaya","48381");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Murueta","Vizcaya","48394");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Muskiz","Vizcaya","48550");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Muxika","Vizcaya","48392");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Nabarniz","Vizcaya","48312");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ondarroa","Vizcaya","48700");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Orozko","Vizcaya","48410");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ortuella","Vizcaya","48530");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Otxandio","Vizcaya","48210");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Plentzia","Vizcaya","48620");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Portugalete","Vizcaya","48920");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Santurtzi","Vizcaya","48980");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Sestao","Vizcaya","48910");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Sondika","Vizcaya","48150");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Sopelana","Vizcaya","48600");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Sopuerta","Vizcaya","48190");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Sukarrieta","Vizcaya","48395");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Trucios-Turtzioz","Vizcaya","48880");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ubide","Vizcaya","48145");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Ugao-Miraballes","Vizcaya","48490");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Urduliz","Vizcaya","48610");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Urduna-Orduna","Vizcaya","48460");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Valle-de-Trapaga-Trapagaran","Vizcaya","48510");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zaldibar","Vizcaya","48250");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zalla","Vizcaya","48860");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zamudio","Vizcaya","48170");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zaratamo","Vizcaya","48480");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zeanuri","Vizcaya","48144");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zeberio","Vizcaya","48499");
insert into poblacion(`nombre_localizacion`,`region`,`codigo_postal`)
values("Zierbena","Vizcaya","48508");





#--------------Productos------------------------
INSERT INTO `productos`(`descripcion`,`nombre`,`precio_producto`)
VALUES("comida deliciosa de dioses","patata","10");
INSERT INTO `productos`(`descripcion`,`nombre`,`precio_producto`)
VALUES("Fluido vital de la creacion","agua","3");
INSERT INTO `productos`(`descripcion`,`nombre`,`precio_producto`)
VALUES("El que no puede faltar","pan","5");



select * from punto_reparto;

select * from pedidos;

select * from productos;


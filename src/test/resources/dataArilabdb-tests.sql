INSERT INTO "admin".biogeo_region (region,region_note) VALUES
	 ('Nearctic','ANTWEB: including most of North America'),
	 ('Neotropic','ANTWEB: including South America and the Caribbean'),
	 ('Palearctic','ANTWEB: including the bulk of Eurasia and North Africa'),
	 ('Afrotropic','ANTWEB: including Sub-Saharan Africa'),
	 ('Malagasy','ANTWEB: Madagascar and Southwest Indian Ocean Islands including Seychelles, Comoros, Mascarenes'),
	 ('Indomalaya','ANTWEB: including the Indian subcontinent and Southeast Asia'),
	 ('Australasia','ANTWEB: including Australia, New Guinea, and neighboring islands. The northern boundary of this zone is known as the Wallace line.'),
	 ('Oceania','ANTWEB: Pacific Ocean islands including Polynesia, Melanesia, Micronesia'),
	 ('Africa',NULL),
	 ('Antarctic',NULL);
INSERT INTO "admin".biogeo_region (region,region_note) VALUES
	 ('Asia-Temperate',NULL),
	 ('Asia-Tropical',NULL),
	 ('Atlantic Ocean',NULL),
	 ('Europe',NULL),
	 ('Indian Ocean',NULL),
	 ('North-Central Pacific',NULL),
	 ('Northern America',NULL),
	 ('Northwestern Pacific',NULL),
	 ('Pacific',NULL),
	 ('South-Central Pacific',NULL);
INSERT INTO "admin".biogeo_region (region,region_note) VALUES
	 ('Southern America',NULL),
	 ('Southwestern Pacific',NULL);

INSERT INTO supplementary.specimen_basis_of_record (basis_of_record) VALUES
	 ('Preserved specimen'),
	 ('Destructive sample'),
	 ('Pin');

INSERT INTO supplementary.ctscans_ethanol_conc (ethanol_conc) VALUES('70%'), ('95%'), ('99%'), ('Not known'), ('No ' ||
 'ethanol used');

INSERT INTO supplementary.ctscans_staining (staining_type) VALUES('Iodine');
INSERT INTO supplementary.ctscans_staining (staining_type) VALUES('PTA');
INSERT INTO supplementary.ctscans_staining (staining_type) VALUES('Osmium');
INSERT INTO supplementary.ctscans_staining (staining_type) VALUES('No staining');




INSERT INTO public.subfamily (subfamily,subfamily_note) VALUES
	 ('Aenictinae',NULL),
	 ('Aenictogitoninae',NULL),
	 ('Agroecomyrmecinae',NULL),
	 ('Amblyoponinae',NULL),
	 ('Aneuretinae',NULL),
	 ('Cerapachyinae',NULL),
	 ('Dolichoderinae',NULL),
	 ('Dorylinae',NULL),
	 ('Ecitoninae',NULL),
	 ('Ectatomminae',NULL);
INSERT INTO public.subfamily (subfamily,subfamily_note) VALUES
	 ('Formicinae',NULL),
	 ('Heteroponerinae',NULL),
	 ('Leptanillinae',NULL),
	 ('Leptanilloidinae',NULL),
	 ('Martialinae',NULL),
	 ('Myrmeciinae',NULL),
	 ('Myrmicinae',NULL),
	 ('Paraponerinae',NULL),
	 ('Ponerinae',NULL),
	 ('Proceratiinae',NULL);
INSERT INTO public.subfamily (subfamily,subfamily_note) VALUES
	 ('Pseudomyrmecinae',NULL),
	 ('(Formicidae)',NULL),
	 ('Sphecomyrminae',NULL);

INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Acanthomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Acanthoponera','Heteroponerinae',NULL,NULL,NULL,NULL),
	 ('Acanthostichus','Cerapachyinae',NULL,NULL,NULL,NULL),
	 ('Acromyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Acropyga','Formicinae',NULL,NULL,NULL,NULL),
	 ('Adelomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Adetomyrma','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Adlerzia','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Aenictogiton','Aenictogitoninae',NULL,NULL,NULL,NULL),
	 ('Colobopsis','Formicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Agraulomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Alloformica','Formicinae',NULL,NULL,NULL,NULL),
	 ('Allomerus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Amblyopone','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Amyrmex','Leptanilloidinae',NULL,NULL,NULL,NULL),
	 ('Ancyridris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Anergates','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Aneuretus','Aneuretinae',NULL,NULL,NULL,NULL),
	 ('Anillomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Anisopheidole','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Ankylomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Anochetus','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Anomalomyrma','Leptanillinae',NULL,NULL,NULL,NULL),
	 ('Anonychomyrma','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Anoplolepis','Formicinae',NULL,NULL,NULL,NULL),
	 ('Aphaenogaster','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Aphomomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Apomyrma','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Apterostigma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Aptinoma','Dolichoderinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Arnoldius','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Asphinctanilloides','Leptanilloidinae',NULL,NULL,NULL,NULL),
	 ('Asphinctopone','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Atopomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Atta','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Aulacopone','Heteroponerinae',NULL,NULL,NULL,NULL),
	 ('Austromorium','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Axinidris','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Bajcaridris','Formicinae',NULL,NULL,NULL,NULL),
	 ('Bannapone','Amblyoponinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Baracidris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Bariamyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Basiceros','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Belonopelta','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Blepharidatta','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Boloponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Bondroitia','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Bothriomyrmex','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Brachymyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Bregmatomyrma','Formicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Calomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Calyptomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Camponotus','Formicinae',NULL,NULL,NULL,NULL),
	 ('Cardiocondyla','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Carebara','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Carebarella','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Cataglyphis','Formicinae',NULL,NULL,NULL,NULL),
	 ('Cataulacus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Cephalotes','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Ooceraea','Dorylinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Chalepoxenus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Cheliomyrmex','Ecitoninae',NULL,NULL,NULL,NULL),
	 ('Chimaeridris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Chronoxenus','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Cladomyrma','Formicinae',NULL,NULL,NULL,NULL),
	 ('Colobostruma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Concoctio','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Crematogaster','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Cryptomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Cylindromyrmex','Cerapachyinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Cyphoidris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Cyphomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Dacatria','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Dacetinops','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Daceton','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Decamorium','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Diacamma','Ponerinae',NULL,NULL,NULL,NULL),
	 ('(Formicinae)','Formicinae',NULL,NULL,NULL,NULL),
	 ('Dilobocondyla','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Dinoponera','Ponerinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Diplomorium','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Discothyrea','Proceratiinae',NULL,NULL,NULL,NULL),
	 ('Doleromyrma','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Dolichoderus','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Dolioponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Dolopomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Dorylus','Dorylinae',NULL,NULL,NULL,NULL),
	 ('Dorymyrmex','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Echinopla','Formicinae',NULL,NULL,NULL,NULL),
	 ('Eciton','Ecitoninae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Ecphorella','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Condylodon',NULL,NULL,NULL,NULL,NULL),
	 ('Hypoppnera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Emeryopone','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Epopostruma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Euprenolepis','Formicinae',NULL,NULL,NULL,NULL),
	 ('Eurhopalothrix','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Eutetramorium','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Forelius','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Forelophilus','Formicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Formica','Formicinae',NULL,NULL,NULL,NULL),
	 ('Formicoxenus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Formosimyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Froggattella','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Furcotanilla','Leptanillinae',NULL,NULL,NULL,NULL),
	 ('Gaoligongidris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Gauromyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Gesomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Gigantiops','Formicinae',NULL,NULL,NULL,NULL),
	 ('Gnamptogenys','Ectatomminae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Goniomma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Gracilidris','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Harpagoxenus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Harpegnathos','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Heteroponera','Heteroponerinae',NULL,NULL,NULL,NULL),
	 ('Huberia','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Hylomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Hypoponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Indomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Iridomyrmex','Dolichoderinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Ishakidris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Kalathomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Kartidris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Labidus','Ecitoninae',NULL,NULL,NULL,NULL),
	 ('Lachnomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Lasiomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Lasiophanes','Formicinae',NULL,NULL,NULL,NULL),
	 ('Lasius','Formicinae',NULL,NULL,NULL,NULL),
	 ('Lenomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Lepisiota','Formicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Leptanilla','Leptanillinae',NULL,NULL,NULL,NULL),
	 ('Leptanilloides','Leptanilloidinae',NULL,NULL,NULL,NULL),
	 ('Leptogenys','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Leptomyrmex','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Leptothorax','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Linepithema','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Liometopum','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Liomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Lophomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Lordomyrma','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Loweriella','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Machomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Manica','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Martialis','Martialinae',NULL,NULL,NULL,NULL),
	 ('Mayriella','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Megalomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Melissotarsus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Melophorus','Formicinae',NULL,NULL,NULL,NULL),
	 ('Meranoplus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Mesostruma','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Messor','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Metapone','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Microdaceton','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Monomorium','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Mycetagroicus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Mycetarotes','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Mycetophylax','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Mycetosoritis','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myopias','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Myopopone','Amblyoponinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Myrcidris','Pseudomyrmecinae',NULL,NULL,NULL,NULL),
	 ('Myrmecia','Myrmeciinae',NULL,NULL,NULL,NULL),
	 ('Myrmecina','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myrmecocystus','Formicinae',NULL,NULL,NULL,NULL),
	 ('Myrmecorhynchus','Formicinae',NULL,NULL,NULL,NULL),
	 ('Myrmelachista','Formicinae',NULL,NULL,NULL,NULL),
	 ('Myrmica','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myrmicaria','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myrmicocrypta','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myrmoteras','Formicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Myrmoxenus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Mystrium','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Nebothriomyrmex','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Neivamyrmex','Ecitoninae',NULL,NULL,NULL,NULL),
	 ('Nesomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Nomamyrmex','Ecitoninae',NULL,NULL,NULL,NULL),
	 ('Nothomyrmecia','Myrmeciinae',NULL,NULL,NULL,NULL),
	 ('Notoncus','Formicinae',NULL,NULL,NULL,NULL),
	 ('Nylanderia','Formicinae',NULL,NULL,NULL,NULL),
	 ('Ochetellus','Dolichoderinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Ochetomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Octostruma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Ocymyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Hypochira',NULL,NULL,NULL,NULL,NULL),
	 ('Odontomachus','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Brachyponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Oecophylla','Formicinae',NULL,NULL,NULL,NULL),
	 ('Onychomyrmex','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Opamyrma','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Opisthopsis','Formicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Orectognathus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Overbeckia','Formicinae',NULL,NULL,NULL,NULL),
	 ('Oxyepoecus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Oxyopomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Papyrius','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Paramycetophylax','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Paraparatrechina','Formicinae',NULL,NULL,NULL,NULL),
	 ('Paraponera','Paraponerinae',NULL,NULL,NULL,NULL),
	 ('(Myrmicinae)','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Paratopula','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Paratrechina','Formicinae',NULL,NULL,NULL,NULL),
	 ('Perissomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Peronomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Petalomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Phalacromyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Phasmomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Phaulomyrma','Leptanillinae',NULL,NULL,NULL,NULL),
	 ('Pheidole','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Pheidologeton','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Philidris','Dolichoderinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Phrynoponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Pilotrochus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Plagiolepis','Formicinae',NULL,NULL,NULL,NULL),
	 ('Platythyrea','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Podomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Poecilomyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Pogonomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Polyergus','Formicinae',NULL,NULL,NULL,NULL),
	 ('Polyrhachis','Formicinae',NULL,NULL,NULL,NULL),
	 ('Ponera','Ponerinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Prenolepis','Formicinae',NULL,NULL,NULL,NULL),
	 ('Prionopelta','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Pristomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Proatta','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Probolomyrmex','Proceratiinae',NULL,NULL,NULL,NULL),
	 ('Proceratium','Proceratiinae',NULL,NULL,NULL,NULL),
	 ('Procryptocerus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Proformica','Formicinae',NULL,NULL,NULL,NULL),
	 ('Prolasius','Formicinae',NULL,NULL,NULL,NULL),
	 ('Promyopias','Ponerinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Propodilobus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Protalaridris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Protanilla','Leptanillinae',NULL,NULL,NULL,NULL),
	 ('Protomognathus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Pseudoatta','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Pseudolasius','Formicinae',NULL,NULL,NULL,NULL),
	 ('Pseudomyrmex','Pseudomyrmecinae',NULL,NULL,NULL,NULL),
	 ('Pseudonotoncus','Formicinae',NULL,NULL,NULL,NULL),
	 ('Ravavy','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Recurvidris','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Rhopalomastix','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Rhopalothrix','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Rhoptromyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Rhytidoponera','Ectatomminae',NULL,NULL,NULL,NULL),
	 ('Rogeria','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Romblonella','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Rossomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Rostromyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Rotastruma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Santschiella','Formicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Secostruma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Sericomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Simopelta','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Simopone','Cerapachyinae',NULL,NULL,NULL,NULL),
	 ('Sphinctomyrmex','Cerapachyinae',NULL,NULL,NULL,NULL),
	 ('Stegomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Stenamma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Stereomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Stigmacros','Formicinae',NULL,NULL,NULL,NULL),
	 ('Stigmatomma','Amblyoponinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Streblognathus','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Strongylognathus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Strumigenys','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Talaridris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Tanipone','Cerapachyinae',NULL,NULL,NULL,NULL),
	 ('Tapinolepis','Formicinae',NULL,NULL,NULL,NULL),
	 ('Tapinoma','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Tatuidris','Agroecomyrmecinae',NULL,NULL,NULL,NULL),
	 ('Technomyrmex','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Teleutomyrmex','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Temnothorax','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Terataner','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Teratomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Tetheamyrma','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Tetraponera','Pseudomyrmecinae',NULL,NULL,NULL,NULL),
	 ('Thaumatomyrmex','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Trachymyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Acanthognathus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Anillidris','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Azteca','Dolichoderinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Centromyrmex','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Dicroaspis','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Ectatomma','Ectatomminae',NULL,NULL,NULL,NULL),
	 ('Feroponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Iberoformica','Formicinae',NULL,NULL,NULL,NULL),
	 ('Loboponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Mycocepurus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Notostigma','Formicinae',NULL,NULL,NULL,NULL),
	 ('Odontoponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Pachycondyla','Ponerinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Plectroctena','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Psalidomyrmex','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Solenopsis','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Tetramorium','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Paraprionopelta','Amblyoponinae',NULL,'incertae sedis',NULL,NULL),
	 ('Tranopelta','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Ectomomyrmex','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Tricytarus','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('(Ponerinae)','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Tropidomyrmex','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Pseudoneoponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Turneria','Dolichoderinae',NULL,NULL,NULL,NULL),
	 ('Pyramica','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Typhlomyrmex','Ectatomminae',NULL,NULL,NULL,NULL),
	 ('Tyrannomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Vicinopone','Cerapachyinae',NULL,NULL,NULL,NULL),
	 ('Vollenhovia','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myrmicinae_genus_FJm03','Myrmicinae',NULL,'Yoshi''s unidentifiable male specimens',NULL,NULL),
	 ('Vombisidris','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myrmicinae_genus_FJm02','Myrmicinae',NULL,'Yoshi''s unidentifiable male specimens',NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Wasmannia','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Myrmicinae_genus_FJm01','Myrmicinae',NULL,'Yoshi''s unidentifiable male specimens',NULL,NULL),
	 ('Xenomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Xymmer','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Yavnella','Leptanillinae',NULL,NULL,NULL,NULL),
	 ('Zatania','Formicinae',NULL,NULL,NULL,NULL),
	 ('Noonilla',NULL,NULL,NULL,NULL,NULL),
	 ('Diaphoromyrma','Myrmicinae',NULL,'incertae sedis',NULL,NULL),
	 ('Dinomyrmex','Formicinae',NULL,NULL,NULL,NULL),
	 ('Syllophopsis','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Pseudoponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Aenictus','Dorylinae',NULL,NULL,NULL,NULL),
	 ('Cerapachys','Dorylinae',NULL,NULL,NULL,NULL),
	 ('Parasyscia','Dorylinae',NULL,NULL,NULL,NULL),
	 ('Syscia','Dorylinae',NULL,NULL,NULL,NULL),
	 ('Trichomyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('(Formicidae)','(Formicidae)',NULL,NULL,NULL,NULL),
	 ('(Dorylinae)','Dorylinae',NULL,NULL,NULL,NULL),
	 ('(Plagiolepidini)','Formicinae',NULL,NULL,NULL,NULL),
	 ('Novomessor','Myrmicinae',NULL,NULL,NULL,NULL);
INSERT INTO public.genus (genus_name,subfamily,tribe,genus_note,senior_synonym,"usage") VALUES
	 ('Fulakora','Amblyoponinae',NULL,NULL,NULL,NULL),
	 ('Gerontoformica','Sphecomyrminae',NULL,NULL,NULL,NULL),
	 ('Rasopone','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Neoponera','Ponerinae',NULL,NULL,NULL,NULL),
	 ('Neocerapachys','Dorylinae',NULL,NULL,NULL,NULL),
	 ('Mycetomoellerius','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Paratrachymyrmex','Myrmicinae',NULL,NULL,NULL,NULL),
	 ('Mayaponera','Ponerinae',NULL,NULL,NULL,NULL);

INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('AD','Andorra','AND'),
	 ('AE','United Arab Emirates','ARE'),
	 ('AF','Afghanistan','AFG'),
	 ('AG','Antigua and Barbuda','ATG'),
	 ('AI','Anguilla','AIA'),
	 ('AL','Albania','ALB'),
	 ('AM','Armenia','ARM'),
	 ('AO','Angola','AGO'),
	 ('AQ','Antarctica','ATA'),
	 ('AR','Argentina','ARG');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('AS','American Samoa','ASM'),
	 ('AT','Austria','AUT'),
	 ('AU','Australia','AUS'),
	 ('AW','Aruba','ABW'),
	 ('AX','Aland Islands','ALA'),
	 ('AZ','Azerbaijan','AZE'),
	 ('BA','Bosnia and Herzegovina','BIH'),
	 ('BB','Barbados','BRB'),
	 ('BD','Bangladesh','BGD'),
	 ('BE','Belgium','BEL');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('BF','Burkina Faso','BFA'),
	 ('BG','Bulgaria','BGR'),
	 ('BH','Bahrain','BHR'),
	 ('BI','Burundi','BDI'),
	 ('BJ','Benin','BEN'),
	 ('BL','Saint Barthelemy','BLM'),
	 ('BM','Bermuda','BMU'),
	 ('BN','Brunei','BRN'),
	 ('BO','Bolivia','BOL'),
	 ('BQ','Bonaire, Saint Eustatius and Saba ','BES');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('BR','Brazil','BRA'),
	 ('BS','Bahamas','BHS'),
	 ('BT','Bhutan','BTN'),
	 ('BV','Bouvet Island','BVT'),
	 ('BW','Botswana','BWA'),
	 ('BY','Belarus','BLR'),
	 ('BZ','Belize','BLZ'),
	 ('CA','Canada','CAN'),
	 ('CC','Cocos Islands','CCK'),
	 ('CD','Democratic Republic of the Congo','COD');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('CF','Central African Republic','CAF'),
	 ('CG','Republic of the Congo','COG'),
	 ('CH','Switzerland','CHE'),
	 ('CI','Ivory Coast','CIV'),
	 ('CK','Cook Islands','COK'),
	 ('CL','Chile','CHL'),
	 ('CM','Cameroon','CMR'),
	 ('CN','China','CHN'),
	 ('CO','Colombia','COL'),
	 ('CR','Costa Rica','CRI');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('CU','Cuba','CUB'),
	 ('CV','Cape Verde','CPV'),
	 ('CW','Curacao','CUW'),
	 ('CX','Christmas Island','CXR'),
	 ('CY','Cyprus','CYP'),
	 ('CZ','Czech Republic','CZE'),
	 ('DE','Germany','DEU'),
	 ('DJ','Djibouti','DJI'),
	 ('DK','Denmark','DNK'),
	 ('DM','Dominica','DMA');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('DO','Dominican Republic','DOM'),
	 ('DZ','Algeria','DZA'),
	 ('EC','Ecuador','ECU'),
	 ('EE','Estonia','EST'),
	 ('EG','Egypt','EGY'),
	 ('EH','Western Sahara','ESH'),
	 ('ER','Eritrea','ERI'),
	 ('ES','Spain','ESP'),
	 ('ET','Ethiopia','ETH'),
	 ('FI','Finland','FIN');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('FJ','Fiji','FJI'),
	 ('FK','Falkland Islands','FLK'),
	 ('FM','Micronesia','FSM'),
	 ('FO','Faroe Islands','FRO'),
	 ('FR','France','FRA'),
	 ('GA','Gabon','GAB'),
	 ('GB','United Kingdom','GBR'),
	 ('GD','Grenada','GRD'),
	 ('GE','Georgia','GEO'),
	 ('GF','French Guiana','GUF');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('GG','Guernsey','GGY'),
	 ('GH','Ghana','GHA'),
	 ('GI','Gibraltar','GIB'),
	 ('GL','Greenland','GRL'),
	 ('GM','Gambia','GMB'),
	 ('GN','Guinea','GIN'),
	 ('GP','Guadeloupe','GLP'),
	 ('GQ','Equatorial Guinea','GNQ'),
	 ('GR','Greece','GRC'),
	 ('GS','South Georgia and the South Sandwich Islands','SGS');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('GT','Guatemala','GTM'),
	 ('GU','Guam','GUM'),
	 ('GW','Guinea-Bissau','GNB'),
	 ('GY','Guyana','GUY'),
	 ('HK','Hong Kong','HKG'),
	 ('HM','Heard Island and McDonald Islands','HMD'),
	 ('HN','Honduras','HND'),
	 ('HR','Croatia','HRV'),
	 ('HT','Haiti','HTI'),
	 ('HU','Hungary','HUN');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('ID','Indonesia','IDN'),
	 ('IE','Ireland','IRL'),
	 ('IL','Israel','ISR'),
	 ('IM','Isle of Man','IMN'),
	 ('IN','India','IND'),
	 ('IO','British Indian Ocean Territory','IOT'),
	 ('IQ','Iraq','IRQ'),
	 ('IR','Iran','IRN'),
	 ('IS','Iceland','ISL'),
	 ('IT','Italy','ITA');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('JE','Jersey','JEY'),
	 ('JM','Jamaica','JAM'),
	 ('JO','Jordan','JOR'),
	 ('JP','Japan','JPN'),
	 ('KE','Kenya','KEN'),
	 ('KG','Kyrgyzstan','KGZ'),
	 ('KH','Cambodia','KHM'),
	 ('KI','Kiribati','KIR'),
	 ('KM','Comoros','COM'),
	 ('KN','Saint Kitts and Nevis','KNA');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('KP','North Korea','PRK'),
	 ('KR','South Korea','KOR'),
	 ('XK','Kosovo','XKX'),
	 ('KW','Kuwait','KWT'),
	 ('KY','Cayman Islands','CYM'),
	 ('KZ','Kazakhstan','KAZ'),
	 ('LA','Laos','LAO'),
	 ('LB','Lebanon','LBN'),
	 ('LC','Saint Lucia','LCA'),
	 ('LI','Liechtenstein','LIE');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('LK','Sri Lanka','LKA'),
	 ('LR','Liberia','LBR'),
	 ('LS','Lesotho','LSO'),
	 ('LT','Lithuania','LTU'),
	 ('LU','Luxembourg','LUX'),
	 ('LV','Latvia','LVA'),
	 ('LY','Libya','LBY'),
	 ('MA','Morocco','MAR'),
	 ('MC','Monaco','MCO'),
	 ('MD','Moldova','MDA');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('ME','Montenegro','MNE'),
	 ('MF','Saint Martin','MAF'),
	 ('MH','Marshall Islands','MHL'),
	 ('MK','Macedonia','MKD'),
	 ('ML','Mali','MLI'),
	 ('MM','Myanmar','MMR'),
	 ('MN','Mongolia','MNG'),
	 ('MO','Macao','MAC'),
	 ('MP','Northern Mariana Islands','MNP'),
	 ('MQ','Martinique','MTQ');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('MR','Mauritania','MRT'),
	 ('MS','Montserrat','MSR'),
	 ('MT','Malta','MLT'),
	 ('MU','Mauritius','MUS'),
	 ('MV','Maldives','MDV'),
	 ('MW','Malawi','MWI'),
	 ('MX','Mexico','MEX'),
	 ('MY','Malaysia','MYS'),
	 ('MZ','Mozambique','MOZ'),
	 ('NA','Namibia','NAM');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('NC','New Caledonia','NCL'),
	 ('NE','Niger','NER'),
	 ('NF','Norfolk Island','NFK'),
	 ('NG','Nigeria','NGA'),
	 ('NI','Nicaragua','NIC'),
	 ('NL','Netherlands','NLD'),
	 ('NO','Norway','NOR'),
	 ('NP','Nepal','NPL'),
	 ('NR','Nauru','NRU'),
	 ('NU','Niue','NIU');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('NZ','New Zealand','NZL'),
	 ('OM','Oman','OMN'),
	 ('PA','Panama','PAN'),
	 ('PE','Peru','PER'),
	 ('PF','French Polynesia','PYF'),
	 ('PG','Papua New Guinea','PNG'),
	 ('PH','Philippines','PHL'),
	 ('PK','Pakistan','PAK'),
	 ('PL','Poland','POL'),
	 ('PM','Saint Pierre and Miquelon','SPM');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('PN','Pitcairn','PCN'),
	 ('PR','Puerto Rico','PRI'),
	 ('PS','Palestinian Territory','PSE'),
	 ('PT','Portugal','PRT'),
	 ('PW','Palau','PLW'),
	 ('PY','Paraguay','PRY'),
	 ('QA','Qatar','QAT'),
	 ('RE','Reunion','REU'),
	 ('RO','Romania','ROU'),
	 ('RS','Serbia','SRB');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('RU','Russia','RUS'),
	 ('RW','Rwanda','RWA'),
	 ('SA','Saudi Arabia','SAU'),
	 ('SB','Solomon Islands','SLB'),
	 ('SC','Seychelles','SYC'),
	 ('SD','Sudan','SDN'),
	 ('SS','South Sudan','SSD'),
	 ('SE','Sweden','SWE'),
	 ('SG','Singapore','SGP'),
	 ('SH','Saint Helena','SHN');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('SI','Slovenia','SVN'),
	 ('SJ','Svalbard and Jan Mayen','SJM'),
	 ('SK','Slovakia','SVK'),
	 ('SL','Sierra Leone','SLE'),
	 ('SM','San Marino','SMR'),
	 ('SN','Senegal','SEN'),
	 ('SO','Somalia','SOM'),
	 ('SR','Suriname','SUR'),
	 ('ST','Sao Tome and Principe','STP'),
	 ('SV','El Salvador','SLV');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('SX','Sint Maarten','SXM'),
	 ('SY','Syria','SYR'),
	 ('SZ','Swaziland','SWZ'),
	 ('TC','Turks and Caicos Islands','TCA'),
	 ('TD','Chad','TCD'),
	 ('TF','French Southern Territories','ATF'),
	 ('TG','Togo','TGO'),
	 ('TH','Thailand','THA'),
	 ('TJ','Tajikistan','TJK'),
	 ('TK','Tokelau','TKL');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('TL','East Timor','TLS'),
	 ('TM','Turkmenistan','TKM'),
	 ('TN','Tunisia','TUN'),
	 ('TO','Tonga','TON'),
	 ('TR','Turkey','TUR'),
	 ('TT','Trinidad and Tobago','TTO'),
	 ('TV','Tuvalu','TUV'),
	 ('TW','Taiwan','TWN'),
	 ('TZ','Tanzania','TZA'),
	 ('UA','Ukraine','UKR');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('UG','Uganda','UGA'),
	 ('UM','United States Minor Outlying Islands','UMI'),
	 ('US','United States','USA'),
	 ('UY','Uruguay','URY'),
	 ('UZ','Uzbekistan','UZB'),
	 ('VA','Vatican','VAT'),
	 ('VC','Saint Vincent and the Grenadines','VCT'),
	 ('VE','Venezuela','VEN'),
	 ('VG','British Virgin Islands','VGB'),
	 ('VI','U.S. Virgin Islands','VIR');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('VN','Vietnam','VNM'),
	 ('VU','Vanuatu','VUT'),
	 ('WF','Wallis and Futuna','WLF'),
	 ('WS','Samoa','WSM'),
	 ('YE','Yemen','YEM'),
	 ('YT','Mayotte','MYT'),
	 ('ZA','South Africa','ZAF'),
	 ('ZM','Zambia','ZMB'),
	 ('ZW','Zimbabwe','ZWE'),
	 ('CS','Serbia and Montenegro','SCG');
INSERT INTO "admin".country (country_code,country_name,iso3_code) VALUES
	 ('AN','Netherlands Antilles','ANT'),
	 ('MG','Madagascar','MDG'),
	 ('00','Unknown','000');

INSERT INTO "admin".specimen_status_types (type_status) VALUES
	 ('Holotype'),
	 ('Isotype'),
	 ('Lectotype'),
	 ('Neotype'),
	 ('Nontype'),
	 ('Not Provided'),
	 ('Paralectotype'),
	 ('Paratype'),
	 ('Syntype');


	 INSERT INTO "admin".taxon_unacc_reason (reason) VALUES
	 ('database artifact'),
	 ('heterotypic (taxonomic) synonym'),
	 ('homonym (illegitimate)'),
	 ('homonym & junior synonym'),
	 ('homotypic (nomenclatural) synonym'),
	 ('horticultural'),
	 ('invalidly published: nomen nudum'),
	 ('invalidly published: other'),
	 ('junior homonym'),
	 ('junior synonym');

INSERT INTO "admin".taxon_unacc_reason (reason) VALUES
	 ('misapplied'),
	 ('nomen dubium'),
	 ('nomen oblitum'),
	 ('objective synonym');



INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Weam 25','Papua New Guinea','Western',NULL,NULL,NULL,'Transfly, Weam',-8.64700000,141.13400000,NULL,25,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Tam Dao','Singapore','Vinh-Phuc',NULL,NULL,NULL,'Tam Dao',21.51820000,105.65300000,40.0,NULL,NULL,'Indomalaya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Curramore','Australia','Queensland',NULL,NULL,NULL,'Curramore (town)',-26.67330000,152.75200000,NULL,300,100,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Tobi Island','Palau','Hatobohei',NULL,NULL,NULL,'Tobi Island',3.00400000,131.17200000,1.0,1,10,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Haute-Garonne','France',NULL,NULL,NULL,NULL,'Haute-Garonne feuille Muret 2044 Est, 518/18211, commune de Beaumont sur Leze',43.36670000,-1.35000000,NULL,NULL,NULL,'Palearctic',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Ngaremlengui 10','Palau',NULL,NULL,NULL,NULL,'Ngaremlengui, South End',7.52025000,134.54700000,NULL,10,10,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Wootha','Australia','Queensland',NULL,NULL,NULL,'Wootha (town)',-26.77500000,152.78500000,NULL,400,100,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Tutong 50','Malaysia','Brunei',NULL,NULL,NULL,'Tutong, Tasek Merimbun',4.50000000,114.60000000,6.0,50,40,'Indomalaya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Lididuniap 189','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Lididuniap Falls',6.91667000,158.19900000,NULL,189,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Lididuniap 157','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Lididuniap Falls',6.92106000,158.20100000,NULL,157,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kitti 105','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Kitti',6.83000000,158.18400000,NULL,105,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Vouvou 890','Papua New Guinea','East New Britain',NULL,NULL,NULL,'Palmalmal, Vouvou',-5.45000000,151.46000000,NULL,890,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Stone trail 9','Micronesia','Yap I.',NULL,NULL,NULL,'Stone trail',9.55510000,138.14000000,NULL,9,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Lamas 244','Papua New Guinea','East New Britain',NULL,NULL,NULL,'Palmalmal, Lamas',-5.61000000,151.41000000,NULL,244,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Tol 139','Micronesia','Chuuk I.',NULL,NULL,NULL,'Tol',7.36800000,151.62000000,NULL,139,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Tol 124','Micronesia','Chuuk I.',NULL,NULL,NULL,'Tol',7.32444000,151.61300000,NULL,124,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Tol 120','Micronesia','Chuuk I.',NULL,NULL,NULL,'Tol',7.32425000,151.61400000,NULL,120,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Kolonia 43','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Kolonia',6.96472000,158.21200000,NULL,43,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Nah 13','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Nah Island',6.85306000,158.35500000,NULL,13,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Nett 508','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Nett',6.89694000,158.20200000,NULL,508,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Nett 640','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Nett',6.89361000,158.20700000,NULL,640,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kitti 79','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Kitti',6.82750000,158.18400000,NULL,79,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Stone trail 82','Micronesia','Yap I.',NULL,NULL,NULL,'Stone trail',9.52722000,138.10700000,NULL,82,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Mt. Madeqdeq 159','Micronesia','Yap I.',NULL,NULL,NULL,'Mt. Madeqdeq',9.52556000,138.11500000,NULL,159,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Weno 81','Micronesia','Chuuk Island',NULL,NULL,NULL,'Weno',7.44792000,151.88400000,NULL,81,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Keoirohi 46','Micronesia','Pohnpei I.',NULL,NULL,NULL,'Keoirohi Falls',6.84556000,158.29900000,NULL,46,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Tompoi 1566','Papua New Guinea','East New Britain',NULL,NULL,NULL,'Palmalmal,',-5.35000000,151.31000000,NULL,1566,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Weno 11','Micronesia','Chuuk Island',NULL,NULL,NULL,'Weno',7.43944000,151.84200000,NULL,11,NULL,'Oceania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kopiago 505','Papua New Guinea','Southern Highlands',NULL,NULL,NULL,'Muller Range, Kopiago',-5.73000000,142.26000000,NULL,505,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Logging area nr. Kg. Yoshina','Malaysia','Sabah',NULL,NULL,NULL,'Logging area near Kg. Yoshina, Ranau',NULL,NULL,NULL,NULL,NULL,'Indomalaya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kopiago 1635','Papua New Guinea','Southern Highlands',NULL,NULL,NULL,'Muller Range, Kopiago',-5.66000000,142.30000000,NULL,1635,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kopiago 1530','Papua New Guinea','Southern Highlands',NULL,NULL,NULL,'Muller Range, Kopiago',-5.66000000,142.30000000,NULL,1530,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kopiago 2000','Papua New Guinea','Southern Highlands',NULL,NULL,NULL,'Muller Range, Kopiago',-5.66000000,142.31000000,NULL,2000,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Vouvou 887','Papua New Guinea','East New Britain',NULL,NULL,NULL,'Palmalmal, Vouvou',-5.45000000,151.46000000,NULL,887,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Vouvou 863','Papua New Guinea','East New Britain',NULL,NULL,NULL,'Palmalmal, Vouvou',-5.45000000,151.47000000,NULL,863,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Tompoi 1652','Papua New Guinea','East New Britain',NULL,NULL,NULL,'Palmalmal, Tompoi',-5.34000000,151.31000000,NULL,1652,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Weam 6','Papua New Guinea','Western',NULL,NULL,NULL,'Transfly, Weam',-8.62000000,141.13000000,NULL,6,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Weam 20','Papua New Guinea','Western',NULL,NULL,NULL,'Transfly, Weam',-8.64300000,141.13500000,NULL,20,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Weam 16','Papua New Guinea','Western',NULL,NULL,NULL,'Transfly, Weam',-8.61900000,141.13500000,NULL,16,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Weam 12','Papua New Guinea','Western',NULL,NULL,NULL,'Transfly, Weam',-8.61000000,141.14400000,NULL,12,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Varirata 800 b','Papua New Guinea','Central',NULL,NULL,NULL,'Port Moresby, Varirata NP',-9.43600000,147.34800000,NULL,800,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Morehead 28','Papua New Guinea','Western',NULL,NULL,NULL,'Morehead',-8.71000000,141.65000000,NULL,28,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Morehead 20','Papua New Guinea','Western',NULL,NULL,NULL,'Morehead',-8.71000000,141.65000000,NULL,20,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Dorogori 14','Papua New Guinea','Western',NULL,NULL,NULL,'Daru, Dorogori',-9.01700000,143.24200000,NULL,14,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Mt. Korolevu 300','Fiji','Lau',NULL,NULL,'ML','Moala, Mt. Korolevu, 5.5 km SW of Naroi Village',-18.59480000,179.90000000,NULL,300,NULL,'Oceania','EMSX146',NULL,'Primary rainforest','primary rainforest',5,1,NULL,NULL),
	 ('Weam 13','Papua New Guinea','Western',NULL,NULL,NULL,'Transfly, Weam',-8.61900000,141.12300000,NULL,13,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Baitabag 55','Papua New Guinea','Madang',NULL,NULL,NULL,'Baitabag',-5.14331000,145.77216000,NULL,55,35,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Musan 700','Nicaragua','Matagalpa',NULL,NULL,NULL,'RN Cerro Musun',12.96006000,-85.22486000,0.01,700,NULL,'Neotropic',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Mahua Waterfall 1000','Malaysia','Sabah',NULL,NULL,NULL,'Mahua Waterfall area, Crocker Range National Park',NULL,NULL,NULL,1000,NULL,'Indomalaya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Ambalanjanakomby 90','Madagascar','Mahajanga',NULL,NULL,NULL,'Ambalanjanakomby',-16.70750000,47.07583000,NULL,90,NULL,'Malagasy',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Navu tu-i-loma','Fiji',NULL,NULL,NULL,'LAU','Lau, Navu tu-i-loma',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Bunso','Ghana',NULL,NULL,NULL,NULL,'Bunso',NULL,NULL,NULL,NULL,NULL,'Afrotropic',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Ambre 1250','Madagascar','Antsiranana',NULL,NULL,NULL,NULL,-12.58502000,49.15147000,NULL,1250,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Andohahela 330','Madagascar',NULL,NULL,NULL,NULL,NULL,-24.73333300,46.80000000,NULL,330,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Baitabag 30','Papua New Guinea','Madang',NULL,NULL,NULL,'Baitabag',-5.14300000,145.77200000,NULL,30,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kirakira 825 b','Solomon Islands','Makira-Ulawa',NULL,NULL,NULL,'13.9 km SSW Kirakira, b/w Marone & Hauta Villages',-10.56680000,161.89200000,NULL,825,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Kirakira 724','Solomon Islands','Makira-Ulawa',NULL,NULL,NULL,'Makira, 14km S Kirakira, b/w Hauta & Marone Villages',-10.57500000,161.90700000,NULL,724,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kirakira 912','Solomon Islands','Makira-Ulawa',NULL,NULL,NULL,'Makira, 14.3km SSW Kirakira nr. Marone Village',-10.57670000,161.89200000,NULL,912,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Kirakira 825','Solomon Islands','Makira-Ulawa',NULL,NULL,NULL,'Makira, 14km SSW Kirakira, b/w Marone & Hauta Villages',-10.57330000,161.89200000,NULL,825,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Smithfield 100','Australia','Queensland',NULL,NULL,NULL,'Smithfield Conservation Park',-16.81670000,145.68300000,NULL,100,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code, country, adm1, adm2, island_group, island, locality_name, latitude, longitude, latlong_error, elevation, elevation_error, biogeographic_region, ems_site, fj_site, ecological_community_original, ecological_community_standard, disturbance, accuracy, other_site, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Andranopasazy 150', 'Madagascar', 'Mahajanga', NULL, NULL, NULL, 'Parc National Tsingy de Bemaraha, 10.6 km ESE 123degree Antsalova', -18.70944000, 44.71817000, NULL, 150, NULL, 'Malagasy', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2014-10-07 10:46:38.755', 'nnarula', '2017-05-08 13:31:41.904', 'jhjanicki', NULL);
INSERT INTO public.locality (locality_code, country, adm1, adm2, island_group, island, locality_name, latitude, longitude, latlong_error, elevation, elevation_error, biogeographic_region, ems_site, fj_site, ecological_community_original, ecological_community_standard, disturbance, accuracy, other_site, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Mt. Naqaranabuluti 1050', 'Fiji', 'Naitasiri', 'Savatu', NULL, 'VL', 'Viti Levu, Mt. Naqaranibuluti, 1.3 km W Emperor Gold Mine Rest House', -17.56940000, 177.97000000, NULL, 1050, NULL, 'Oceania', 'EMSX65', NULL, 'primary rainforest', 'primary rainforest', 5, 1, NULL, '2014-02-24 13:59:09.829', 'nnarula', '2014-03-25 11:43:40.128', 'nnarula', NULL);
INSERT INTO public.locality (locality_code, country, adm1, adm2, island_group, island, locality_name, latitude, longitude, latlong_error, elevation, elevation_error, biogeographic_region, ems_site, fj_site, ecological_community_original, ecological_community_standard, disturbance, accuracy, other_site, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Abaca 410', 'Fiji', 'Vunda', NULL, NULL, 'VL', 'Viti Levu, Abaca Village', -17.66730000, 177.53500000, NULL, 410, NULL, 'Oceania', 'EMSX202', NULL, 'rainforest edge', 'forest edge', 3, 1, NULL, '2014-03-10 13:03:24.809', 'nnarula', '2014-03-25 11:43:39.725', 'nnarula', NULL);
INSERT INTO public.locality (locality_code, country, adm1, adm2, island_group, island, locality_name, latitude, longitude, latlong_error, elevation, elevation_error, biogeographic_region, ems_site, fj_site, ecological_community_original, ecological_community_standard, disturbance, accuracy, other_site, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Navai 863', 'Fiji', 'Naitasiri', NULL, NULL, 'VL', 'Viti Levu, 0.9 km E Navai, trail to Mt. Tomanivi (Mt. Victoria)', -17.61960000, 177.99000000, NULL, 863, NULL, 'Oceania', 'EMSX57', NULL, 'secondary rainforest/pasture edge', 'forest edge', 3, 1, NULL, '2014-02-24 13:59:11.839', 'nnarula', '2014-03-25 11:43:40.324', 'nnarula', NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Haia 700','Papua New Guinea','Chimbu',NULL,NULL,NULL,'10.5 km SSE Haia airstrip',-6.80000000,145.01700000,NULL,700,NULL,'Australasia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Mt. Delaikoro 699','Fiji','Cakaudrove',NULL,NULL,'VN','Vanua Levu, Mt. Delaikoro, Delaikoro Rd., 3.6 km SE Dogoru Village',-16.57530000,179.31600000,NULL,699,NULL,'Oceania','EMSX110',NULL,'mid-elevation rainforest','primary rainforest',5,1,NULL,NULL),
	 ('Tucson 775','United States','Arizona','Pima',NULL,NULL,'Tucson, Between Fairmount St. and Van Buren Ave.',32.22000000,-110.92600000,10.0,775,NULL,'Nearctic',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('XTBG 581','China','Yunnan','Xishuangbanna',NULL,NULL,'Yunnan Prov., Xishuangbanna., XTBG',21.91755600,101.27075000,NULL,581,581,'Indomalaya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.locality (locality_code,country,adm1,adm2,island_group,island,locality_name,latitude,longitude,latlong_error,elevation,elevation_error,biogeographic_region,ems_site,fj_site,ecological_community_original,ecological_community_standard,disturbance,accuracy,other_site,jira_user) VALUES
	 ('Monasavu 850','Fiji','Ba',NULL,NULL,'VL','Viti Levu, Monasavu Rd., 1.75 km SE Waimoque Settlement',-17.67030000,177.99400000,NULL,850,NULL,'Oceania','EMSX107',NULL,'logging road, mid-elevation forest','rainforest',4,1,NULL,NULL),
	 ('Colo-i-Suva 186 d','Fiji','Rewa',NULL,NULL,'VL','Viti Levu, Colo-i-Suva Forest Park, 1 km SE Forestry Station',-18.06660000,178.44300000,NULL,186,NULL,'Oceania','EMSX184',NULL,'Primary rainforest','secondary rainforest',4,1,NULL,NULL),
	 ('Kokabula 800','Fiji',NULL,NULL,NULL,'VL','Viti Levu, Mt. Evans Range, Koroyanitu Eco Park, Kokabula Trail, 1 km E Abaca Village',-17.66670000,177.55000000,NULL,800,NULL,'Oceania',NULL,'FJVL02','disturbed mid-elevation moist forest','disturbed forest',4,1,NULL,NULL);



INSERT INTO public.collection_event (collection_event_code,locality_code,collected_by,"method",sampling_effort,date_collected_start,date_collected_end,date_flag,habitat,microhabitat,behavior,disturbance_level,jira_user) VALUES
	 ('JK00174','Kirakira 724','W. Gronenberg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('AL0616','Kirakira 724','A. Lucky',NULL,NULL,'2009-09-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('BLF21421','Ambalanjanakomby 90',NULL,NULL,NULL,NULL,NULL,NULL,'montane rainforest','ex rotten log',NULL,NULL,NULL),
	 ('AL0581','Kopiago 1635','A. Lucky',NULL,NULL,'2009-09-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('AL0637','Kopiago 1635','A. Lucky',NULL,NULL,'2009-09-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('802.PHE.1','Kirakira 825','R. Clouse',NULL,NULL,'2009-09-03',NULL,NULL,'High Tide Hotel room',NULL,NULL,NULL,NULL),
	 ('803.PHE.1','Kirakira 825','R. Clouse',NULL,NULL,'2010-09-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('803.PHE.2','Morehead 28','R. Clouse',NULL,NULL,'2010-09-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('803.PHE.3','Morehead 28','R. Clouse',NULL,NULL,'2010-09-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('808.PHE.1','Weam 13','R. Clouse, Techuo Fam.',NULL,NULL,'2010-09-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.collection_event (collection_event_code,locality_code,collected_by,"method",sampling_effort,date_collected_start,date_collected_end,date_flag,habitat,microhabitat,behavior,disturbance_level,jira_user) VALUES
	 ('809.PHE.1','Weam 13','R. Clouse, Techuo Fam.',NULL,NULL,'2010-09-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('811.PHE.1','Weam 13','R. Clouse, Techuo Fam.',NULL,NULL,'2010-09-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('813.PHE.1','Weam 13','R. Clouse, Techuo Fam.',NULL,NULL,'2010-09-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('813.PHE.2','Kopiago 505','R. Clouse, Techuo Fam.',NULL,NULL,'2010-09-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('814.PHE.2','Kopiago 505','R. Clouse, Sharma',NULL,NULL,'2010-09-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('815.PHE.1','Kopiago 505','R. Clouse, Sharma',NULL,NULL,'2010-09-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('819.PHE','Lididuniap 189','R. Clouse, Eperiam, Sharma',NULL,NULL,'2010-09-10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('819.PHE.1','Lididuniap 189','R. Clouse, Eperiam, Sharma',NULL,NULL,'2010-09-10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('827.PHE.1','Lididuniap 189','R. Clouse, Daniel, Sharma',NULL,NULL,'2010-09-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('830.PHE.1','Lididuniap 189','R. Clouse, Sharma',NULL,NULL,'2010-09-11',NULL,NULL,'On car',NULL,NULL,NULL,NULL);
INSERT INTO public.collection_event (collection_event_code, locality_code, collected_by, "method", sampling_effort, date_collected_start, date_collected_end, date_flag, habitat, microhabitat, behavior, disturbance_level, insert_date, insert_user, update_date, update_user, jira_user) VALUES('BLF04446', 'Andranopasazy 150', 'Fisher-Griswold Arthropod Team', NULL, NULL, '2001-11-16', '2001-11-20', NULL, 'tropical dry forest on Tsingy', 'ex dead twig above ground', NULL, NULL, '2014-10-07 11:25:17.240', 'nnarula', NULL, NULL, NULL);
INSERT INTO public.collection_event (collection_event_code, locality_code, collected_by, "method", sampling_effort, date_collected_start, date_collected_end, date_flag, habitat, microhabitat, behavior, disturbance_level, insert_date, insert_user, update_date, update_user, jira_user) VALUES('EMS2116', 'Mt. Naqaranabuluti 1050', 'E. M. Sarnat', 'H', NULL, '2005-06-24', NULL, 3, 'primary rainforest', NULL, NULL, NULL, '2014-03-10 14:37:21.238', 'nnarula', '2015-12-16 05:26:57.789', 'esarnat', NULL);
INSERT INTO public.collection_event (collection_event_code, locality_code, collected_by, "method", sampling_effort, date_collected_start, date_collected_end, date_flag, habitat, microhabitat, behavior, disturbance_level, insert_date, insert_user, update_date, update_user, jira_user) VALUES('EMS1838', 'Abaca 410', 'E. M. Sarnat', 'H', NULL, '2005-02-04', NULL, NULL, 'primary rainforest', 'foraging on vegetation', 'foraging', NULL, '2014-03-10 14:37:21.103', 'nnarula', '2015-12-17 06:07:24.215', 'nnarula', NULL);
INSERT INTO public.collection_event (collection_event_code, locality_code, collected_by, "method", sampling_effort, date_collected_start, date_collected_end, date_flag, habitat, microhabitat, behavior, disturbance_level, insert_date, insert_user, update_date, update_user, jira_user) VALUES('EMS1791', 'Navai 863', 'E. M. Sarnat', 'L', NULL, '2005-02-01', NULL, NULL, 'forest edge', 'ex. soil, leaf itter, decaying wood', NULL, NULL, '2014-02-24 15:14:12.016', 'nnarula', '2014-03-31 13:11:11.261', 'nnarula', NULL);
INSERT INTO public.collection_event (collection_event_code,locality_code,collected_by,"method",sampling_effort,date_collected_start,date_collected_end,date_flag,habitat,microhabitat,behavior,disturbance_level,jira_user) VALUES
	 ('EMS793','Haia 700','EM Sarnat',NULL,NULL,'2003-02-15',NULL,NULL,'1˚ rainforest','ground foraging',NULL,NULL,NULL),
	 ('JK00175','Tucson 775','Wulfilfa Gronenberg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'shubham-gautam'),
	 ('EPE63.06','Mt. Delaikoro 699','E. P. Economo','L',NULL,'2006-08-31',NULL,NULL,'primary rainforest','sifted litter',NULL,NULL,NULL),
	 ('CL015.23','XTBG 581','B. Guénard, B. Blanchard, C. Liu','m2 Winkler sifting',NULL,'2013-06-05','2013-06-05',NULL,'rain forest',NULL,NULL,NULL,NULL),
	 ('EMS2375','Mt. Delaikoro 699','E. M. Sarnat','H',NULL,'2006-08-31',NULL,NULL,'primary rainforest','nesting in soil','nesting',NULL,NULL);
INSERT INTO public.collection_event (collection_event_code,locality_code,collected_by,"method",sampling_effort,date_collected_start,date_collected_end,date_flag,habitat,microhabitat,behavior,disturbance_level,jira_user) VALUES
	 ('EMS2365','Monasavu 850','E. M. Sarnat','H',NULL,'2006-08-28',NULL,NULL,'rainforest','nesting turret nest in bare soil','nesting',NULL,NULL),
	 ('EMS2483','Colo-i-Suva 186 d','E. M. Sarnat','H',NULL,'2007-06-30',NULL,NULL,'secondary rainforest','tending homopteran on vegetation','tending homopteran',NULL,NULL),
	 ('FJVL02_M01_04','Kokabula 800','Tuimereke, L.','M',NULL,'2002-10-19','2002-10-26',NULL,'disturbed forest','malaise trap',NULL,NULL,NULL);

INSERT INTO public.species (taxon_code,genus_name,species_name,subspecies,morpho_code,senior_synonym,unacceptibility_reason,species_group,species_complex,affinity,vernacular_names,type_locality,type_depository,"usage",species_author,species_author_year,jira_user) VALUES
	 ('Pheidole.hercules_cf','Pheidole',NULL,NULL,'hercules_cf',NULL,NULL,'quadrispinosa','hercules',NULL,NULL,NULL,NULL,false,NULL,NULL,NULL),
	 ('Pheidole.gf015','Pheidole',NULL,NULL,'gf015',NULL,NULL,NULL,NULL,'cf oculata',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Strumigenys.augustandrewi','Strumigenys','augustandrewi',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Strumigenys.hemichlaena','Strumigenys','hemichlaena',NULL,NULL,'Pheidole.BP12',NULL,NULL,NULL,NULL,NULL,'Mexico',NULL,NULL,NULL,NULL,NULL),
	 ('Strumigenys.ignota','Strumigenys','ignota',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Pheidole.ankerana08','Pheidole',NULL,NULL,'ankerana08',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Pheidole.BP12','Pheidole',NULL,NULL,'BP12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,false,NULL,NULL,NULL),
	 ('Pheidole.protensa','Pheidole','protensa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Mexico',NULL,true,'Wilson',2003,NULL),
	 ('Pheidole.pugnax','Pheidole','pugnax',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Costa Rica',NULL,true,'Dalla ' ||
	  'Torre',1892,NULL);
INSERT INTO public.species (taxon_code,genus_name,species_name,subspecies,morpho_code,senior_synonym,unacceptibility_reason,species_group,species_complex,affinity,vernacular_names,type_locality,type_depository,"usage",species_author,species_author_year,jira_user) VALUES
	 ('Pheidole.EPEM068','Pheidole',NULL,NULL,'EPEM068',NULL,NULL,'onifera',NULL,'cf variabilis',NULL,NULL,NULL,false,NULL,NULL,NULL),
	 ('Pheidole.gf085','Pheidole',NULL,NULL,'gf085',NULL,NULL,NULL,NULL,'nr pieli',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Pheidole.purpurea','Pheidole','purpurea',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Mexico',NULL,true,'Longino',2009,NULL),
	 ('Pheidole.texticeps','Pheidole','texticeps',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Costa Rica',NULL,true,'Wilson',2003,NULL),
	 ('Ancyridris.(indet)','Ancyridris','(indet)',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Pheidole.EPEM184','Pheidole',NULL,NULL,'EPEM184','Pheidole.purpurea',NULL,NULL,NULL,NULL,NULL,NULL,NULL,false,NULL,NULL,NULL),
	 ('Pheidole.EPEM182','Pheidole',NULL,NULL,'EPEM182','Pheidole.texticeps',NULL,NULL,NULL,NULL,NULL,NULL,NULL,
	 false,NULL,NULL,NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Aenictus.(indet)', 'Aenictus', '(indet)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2014-02-21 15:46:45.615', 'nnarula', '2014-02-25 11:00:15.694', 'nnarula', NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code,
     senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Stigmatomma.(indet)', 'Stigmatomma', '(indet)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2014-02-21 15:46:49.624', 'nnarula', '2014-02-25 11:00:15.694', 'nnarula', NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code,
     senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Terataner.fhg-drow', 'Terataner', 'fhg-drow', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2017-05-08 14:36:03.991', 'jhjanicki', '2019-02-01 14:58:35.443', 'fgarcia', NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Dorylus.Kohli', 'Dorylus', 'Kohli', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-29 11:36:53.041', 'kosmas', NULL, NULL, NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Strumigenys.ohioensis', 'Strumigenys', 'ohioensis', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-02-20 11:02:18.379', 'jdeyrup', NULL, NULL, NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Orectognathus.versicolor', 'Orectognathus', 'versicolor', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-30 13:55:58.910', 'jira', NULL, NULL, 'julian-katzke');
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Ooceraea.fuscior', 'Ooceraea', 'fuscior', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, true, 'Mann', NULL, '2016-08-11 02:01:50.113', 'esarnat', NULL, NULL, NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Terataner.fhg-gand', 'Terataner', 'fhg-gand', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2017-05-08 14:36:04.039', 'jhjanicki', '2019-02-02 13:45:29.662', 'fgarcia', NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Strumigenys.predator', 'Strumigenys', 'predator', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-08 08:43:04.318', 'esarnat', NULL, NULL, NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Strumigenys.ornata', 'Strumigenys', 'ornata', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-02-20 11:02:18.388', 'jdeyrup', NULL, NULL, NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Strumigenys.clypeata', 'Strumigenys', 'clypeata', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-02-20 11:02:17.905', 'jdeyrup', NULL, NULL, NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Pheidole.oceanica', 'Pheidole', 'oceanica', NULL, NULL, NULL, NULL, 'oceanica', NULL, NULL, NULL, 'Fiji', NULL, true, 'Mayr', 1866, '2014-02-21 18:28:13.296', 'nnarula', '2016-02-05 03:31:55.910', 'esarnat', NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Terataner.fhg-vena', 'Terataner', 'fhg-vena', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2017-05-08 14:36:03.597', 'jhjanicki', '2017-05-08 14:36:03.600', 'jhjanicki', NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Pheidole.knowlesi', 'Pheidole', 'knowlesi', NULL, NULL, NULL, NULL, 'knowlesi', NULL, NULL, NULL, 'Fiji', NULL, true, 'Mann', 1921, '2014-02-21 18:28:13.095', 'nnarula', '2014-02-25 11:00:15.694', 'nnarula', NULL);
INSERT INTO public.species (taxon_code, genus_name, species_name, subspecies, morpho_code, senior_synonym, unacceptibility_reason, species_group, species_complex, affinity, vernacular_names, type_locality, type_depository, "usage", species_author, species_author_year, insert_date, insert_user, update_date, update_user, jira_user) VALUES('Pheidole.fervens', 'Pheidole', 'fervens', NULL, NULL, NULL, NULL, 'oceanica', NULL, NULL, NULL, NULL, NULL, true, 'Smith', 1858, '2014-02-21 18:28:12.929', 'nnarula', '2016-02-05 03:31:55.540', 'esarnat', NULL);
INSERT INTO public.species (taxon_code,genus_name,species_name,subspecies,morpho_code,senior_synonym,unacceptibility_reason,species_group,species_complex,affinity,vernacular_names,type_locality,type_depository,"usage",species_author,species_author_year,jira_user) VALUES
	 ('Pheidole.PG03','Pheidole',NULL,NULL,'PG03',NULL,NULL,'bifurca','bifurca',NULL,NULL,NULL,NULL,false,NULL,NULL,NULL),
	 ('Pheidole.simplispinosa','Pheidole','simplispinosa',NULL,NULL,NULL,NULL,'roosevelti',NULL,NULL,NULL,'Fiji',NULL,true,'Sarnat',2008,NULL),
	 ('Pheidole.bula','Pheidole','bula',NULL,NULL,NULL,NULL,'roosevelti',NULL,NULL,NULL,'Fiji',NULL,true,'Sarnat',2008,NULL),
	 ('Nylanderia.braueri','Nylanderia','braueri',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Monomorium.CLM010001','Monomorium',NULL,NULL,'CLM010001',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('Gerontoformica.sp','Gerontoformica','sp',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'julian-katzke'),
	 ('Novomessor.cockerelli','Novomessor','cockerelli',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'julian-katzke');
INSERT INTO public.species (taxon_code,genus_name,species_name,subspecies,morpho_code,senior_synonym,unacceptibility_reason,species_group,species_complex,affinity,vernacular_names,type_locality,type_depository,"usage",species_author,species_author_year,jira_user) VALUES
	 ('Pheidole.colaensis','Pheidole','colaensis',NULL,NULL,NULL,NULL,'roosevelti',NULL,NULL,NULL,'Fiji',NULL,true,'Mann',1921,NULL),
	 ('Colobopsis.cristata','Colobopsis','cristata',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,true,NULL,NULL,NULL),
	 ('Nylanderia.vaga','Nylanderia','vaga',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);


INSERT INTO public.specimen (specimen_code,sample_code,collection_event_code,basis_of_record,located_at,owned_by,lifestagesex,medium,type_status,taxon_code,determined_by,date_identified,fba_code,fj_code,epe_code,ems_code,other_code,flag,transect_notes,antweb_manage,jira_user) VALUES
	 ('CASENT0842667',NULL,'JK00174',NULL,'OIST','UC Davis',NULL,'alcohol','Not Provided','Aenictus.(indet)',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0842668',NULL,'JK00174',NULL,'OIST','UC Davis',NULL,'alcohol','Not Provided','Stigmatomma.(indet)',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0411005',NULL,'AL0616',NULL,'on loan to F. Hita Garcia, OIST','CASC, San Francisco, CA, USA','1w','pin','Not Provided','Terataner.fhg-drow','F. Hita Garcia','2014-07-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0709271',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Not Provided','Dorylus.Kohli',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0749498',NULL,'AL0616','Destructive sample','Destroyed','DBBC','1w','DNA sample only','Not Provided','Strumigenys.ohioensis','D. Booher',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
	 ('CASENT0411002',NULL,'AL0616',NULL,'CASC','CASC, San Francisco, CA, USA','1w','pin','Not Provided','Terataner.fhg-drow','F. Hita Garcia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
	 ('CASENT0741227','PSW15299','AL0637','Preserved specimen',NULL,NULL,NULL,NULL,'Not Provided','Orectognathus.versicolor',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'julian-katzke'),
	 ('83317',NULL,NULL,NULL,NULL,'SmithosonianInstitution',NULL,NULL,'Not Provided',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Gfas','patricia’s coral sample',NULL,NULL,NULL),
	 ('1154300',NULL,NULL,NULL,NULL,'SmithosonianInstitution',NULL,NULL,'Not Provided',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Gfas','patricia’s coral sample',NULL,NULL,NULL),
	 ('1154345',NULL,NULL,NULL,NULL,'SmithosonianInstitution',NULL,NULL,'Not Provided',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Gfas','patricia’s coral sample',NULL,NULL,NULL);


INSERT INTO public.specimen (specimen_code,sample_code,collection_event_code,basis_of_record,located_at,owned_by,lifestagesex,medium,type_status,taxon_code,determined_by,date_identified,fba_code,fj_code,epe_code,ems_code,other_code,flag,transect_notes,antweb_manage,jira_user) VALUES
	 ('CASENT0233725',NULL,'830.PHE.1',NULL,'NMNH','NMNH','w','pin; no physical CASENT label on pin','Syntype','Ooceraea.fuscior',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),
	 ('CASENT0041670',NULL,'830.PHE.1',NULL,'CASC','CASC, San Francisco, CA, USA','1w','pin','Not Provided','Terataner.fhg-gand','F. Hita Garcia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
	 ('CASENT0185928',NULL,'830.PHE.1',NULL,'EPEC','EMSC','1w','pin','Paratype','Strumigenys.predator',NULL,NULL,NULL,'FJVL500',NULL,'EMS2137',NULL,NULL,NULL,0,NULL),
	 ('CASENT0749500',NULL,'813.PHE.1','Destructive sample','Destroyed','DBBC','1w','DNA sample only','Not Provided','Strumigenys.ornata','D. Booher',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
	 ('CASENT0749501',NULL,'813.PHE.1','Destructive sample','Destroyed','DBBC','1w','DNA sample only','Not Provided','Strumigenys.clypeata','D. Booher',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
	 ('CASENT0749502',NULL,'813.PHE.1','Destructive sample','Destroyed','DBBC','1w','DNA sample only','Not Provided','Strumigenys.clypeata','D. Booher',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
	 ('CASENT0743190',NULL,'813.PHE.1','Destructive sample',NULL,NULL,NULL,'DNA only','Not Provided','Pheidole.oceanica',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0743229',NULL,'813.PHE.1','Destructive sample',NULL,NULL,NULL,'DNA only','Not Provided','Pheidole.oceanica',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0743014',NULL,'BLF21421','Destructive sample',NULL,NULL,NULL,'DNA only','Not Provided','Pheidole' ||
	  '.oceanica',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

INSERT INTO public.specimen (specimen_code,sample_code,collection_event_code,basis_of_record,located_at,owned_by,lifestagesex,medium,type_status,taxon_code,determined_by,date_identified,fba_code,fj_code,epe_code,ems_code,other_code,flag,transect_notes,antweb_manage,jira_user) VALUES
	 ('CASENT0000538',NULL,'BLF04446',NULL,'CASC','CASC, San Francisco, CA, USA','1w','pin','Not Provided','Terataner.fhg-vena','F. Hita Garcia','2018-08-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
	 ('CASENT0171098',NULL,'EMS2116',NULL,'EMSC','EMSC','1m','pin','Not Provided','Pheidole.knowlesi',NULL,'2011-03-21',NULL,'FJVL500',NULL,'EMS2116',NULL,NULL,NULL,1,NULL),
	 ('CASENT0171099',NULL,'EMS1838',NULL,'EMSC','EMSC','1s','pin','Not Provided','Pheidole.fervens',NULL,NULL,NULL,'FJVL566_M04',NULL,'EMS1838',NULL,NULL,NULL,1,NULL),
	 ('CASENT0174013',NULL,'EMS1791',NULL,'EPEC','EMSC','1w','pin','Not Provided','Pheidole.bula',NULL,NULL,NULL,NULL,NULL,'EMS1791',NULL,NULL,NULL,1,NULL),
	 ('CASENT0174250',NULL,'EMS2375',NULL,'EPEC','EMSC','1w','pin','Not Provided','Pheidole.simplispinosa',NULL,NULL,NULL,NULL,NULL,'EMS2375',NULL,NULL,NULL,1,NULL),
	 ('CASENT0181506',NULL,'EPE63.06',NULL,'EPEC','EPEC','1w','pin','Not Provided','Nylanderia.braueri',NULL,NULL,NULL,NULL,'EPE63.06',NULL,NULL,NULL,NULL,1,NULL),
	 ('CASENT0282333','EMS793','EMS793','Preserved specimen','EMSC','EPEC','1w','pin','Not Provided','Pheidole.PG03','Sarnat, E.M.','2013-07-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),
	 ('CASENT0714080',NULL,'CL015.23','Preserved specimen','OIST','EPEC','1 W','pin','Not Provided','Monomorium.CLM010001',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),
	 ('CASENT0741222',NULL,'JK00175',NULL,NULL,NULL,'worker','plastic','Nontype','Novomessor.cockerelli',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'julian-katzke'),
	 ('CASENT0741223',NULL,'JK00174',NULL,NULL,NULL,'worker','plastic','Nontype','Novomessor.cockerelli','Wulfila Gronenberg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'julian-katzke');
INSERT INTO public.specimen (specimen_code,sample_code,collection_event_code,basis_of_record,located_at,owned_by,lifestagesex,medium,type_status,taxon_code,determined_by,date_identified,fba_code,fj_code,epe_code,ems_code,other_code,flag,transect_notes,antweb_manage,jira_user) VALUES
	 ('CASENT0741232',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Not Provided','Gerontoformica.sp',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'julian-katzke');

INSERT INTO public.specimen (specimen_code,sample_code,collection_event_code,basis_of_record,located_at,owned_by,lifestagesex,medium,type_status,taxon_code,determined_by,date_identified,fba_code,fj_code,epe_code,ems_code,other_code,flag,transect_notes,antweb_manage,jira_user) VALUES
	 ('CASENT0174049',NULL,'EMS2365',NULL,'EPEC','EMSC','1w','pin','Not Provided','Pheidole.colaensis',NULL,NULL,NULL,NULL,NULL,'EMS2365',NULL,NULL,NULL,1,NULL),
	 ('CASENT0180226',NULL,'FJVL02_M01_04',NULL,'EPEC','EPEC','1w','pin','Not Provided','Colobopsis.cristata',NULL,NULL,'FBA085485',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),
	 ('CASENT0181342',NULL,'EMS2483',NULL,'EPEC','EMSC','1w','pin','Not Provided','Nylanderia.vaga',NULL,NULL,NULL,NULL,NULL,'EMS2483',NULL,NULL,NULL,1,NULL);

INSERT INTO public.ctscans (specimen_code,ct_scan_note,voxel_size,exposure_time,projections,ethanol_conc,wet,body_part,special_identifier,folder_location,scan_user,insert_user,staining,antscan,antscan_code,model,dry_method,scan_reason,prep_note) VALUES
	 ('CASENT0000538',NULL,NULL,NULL,NULL,'95%','Yes','Head',NULL,'Z:\CTScans\Ants\Terataner\fhg-vena\CASENT0000538_Ter_Head_2020-02-02_000000','kosmas-deligkaris','jira','No staining','No',NULL,'Ants',NULL,NULL,NULL),
	 ('CASENT0741232','Fossil Ant in Amber with some soft tissue preservation',NULL,NULL,NULL,'No ethanol used','No','Whole_body',NULL,'Z:\CTScans\Ants\Gerontoformica\sp\CASENT0741232_Ger_Whole_body_2020-06-17_105837','julian-katzke','jira','No staining','No',NULL,'Ants','Amber',NULL,NULL),
	 ('CASENT0741232','Fossil Ant in Amber with some soft tissue preservation',NULL,NULL,NULL,'No ethanol used','No','Head',NULL,'Y:\CTScans\Ants\Gerontoformica\sp\CASENT0741232_Ger_Head_2020-06-28_112803','julian-katzke','jira','No staining','No',NULL,'Ants','Amber',NULL,NULL),
	 ('CASENT0741232','Fossil Ant in Amber with some soft tissue preservation',NULL,NULL,NULL,'No ethanol used','No','Thorax',NULL,'Y:\CTScans\Ants\Gerontoformica\sp\CASENT0741232_Ger_Thorax_2020-07-02_093537','julian-katzke','jira','No staining','No',NULL,'Ants','Amber',NULL,NULL),
	 ('CASENT0282333','some streaks',NULL,NULL,NULL,'Not known',NULL,NULL,NULL,NULL,'Unknown',NULL,NULL,'No',NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0714080','good, specimen missing abdomen',4.5146,NULL,NULL,'Not known',NULL,NULL,NULL,NULL,'Unknown',NULL,NULL,'No',NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0741223','Plastic embedded OsO4 stained Novomessor head',NULL,NULL,NULL,'No ethanol used','No','Head',NULL,'CTScans/Ants/Novomessor/cockerelli/CASENT0741223_Nov_Head_2020-01-13_123523','julian-katzke','jira','Osmium','No',NULL,NULL,'Resin',NULL,NULL),
	 ('CASENT0741222','not fully stained, good image quality',NULL,NULL,NULL,'No ethanol used','No','Head','Brain_dissect','CTScans/Ants/Novomessor/cockerelli/CASENT0741222_Nov_Head_Brain_dissect_2020-01-31_142856','julian-katzke','jira','Osmium','No',NULL,NULL,'Resin',NULL,NULL),
	 ('CASENT0181506','blurry, streaks',2.6232,NULL,NULL,'Not known',NULL,NULL,NULL,
	 NULL,'Unknown',NULL,NULL,'No',NULL,NULL,NULL,NULL,NULL);
INSERT INTO public.ctscans (specimen_code,ct_scan_note,voxel_size,exposure_time,projections,ethanol_conc,wet,body_part,special_identifier,folder_location,scan_user,insert_user,staining,antscan,antscan_code,model,dry_method,scan_reason,prep_note) VALUES
	 ('CASENT0180226','good, scan missing part of abdomen',5.3578,3.0,3200,'Not known',NULL,NULL,NULL,NULL,'Unknown',NULL,NULL,'No',NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0181342','blurry',NULL,NULL,NULL,'Not known',NULL,NULL,NULL,NULL,'Unknown',NULL,NULL,'No',NULL,NULL,NULL,NULL,NULL),
	 ('CASENT0174049','good, scan missing part of abdomen',5.2039,20.0,1600,'Not known',NULL,NULL,NULL,NULL,'Unknown',NULL,NULL,'No',NULL,NULL,NULL,NULL,NULL);
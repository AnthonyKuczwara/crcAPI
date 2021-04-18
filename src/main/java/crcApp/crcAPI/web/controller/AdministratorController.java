package crcApp.crcAPI.web.controller;

import crcApp.crcAPI.data.model.*;
import crcApp.crcAPI.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {


    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private NccFoodGroupCategoryRepository nccFoodGroupCategoryRepository;
    @Autowired
    private CommonPortionSizeDescriptionRepository commonPortionSizeDescriptionRepository;
    @Autowired
    private CommonPortionSizeUnitRepository commonPortionSizeUnitRepository;


    /**
     * This method parses a csv file and saves food information to the database.
     */
    @PostMapping(value = "/upload/")
    public String insertData(@RequestParam("file") MultipartFile file) throws IOException {
        // Check if file is csv
        if (file.getContentType() != "txt/csv") {
            return "error";
        }
//        Scanner fileReader = null;
        BufferedReader br = null;
        try {
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
//            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND. CHECK PATH/NAME");
            e.printStackTrace();
            return "error";

        }
        try {
            // Skip the header information
            br.readLine();
//            fileReader.nextLine();
            String line = "";
            // Parse each line of the csv
            while ((line = br.readLine()) != null) {
//                String line = fileReader.nextLine();
                String[] foodInfo = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                int baseId = Integer.parseInt(foodInfo[0]);
                String keylist = foodInfo[1];
                String description = foodInfo[3];
                double commonPortionSizeAmount = Double.parseDouble(foodInfo[4]);
                String commonPortionSizeUnit = foodInfo[5];
                String commonPortionSizeDescription = foodInfo[6];
                double commonPortionSizeGramWeight = Double.parseDouble(foodInfo[7]);
                String foodType = foodInfo[8];
                String nccFoodGroupCategory = foodInfo[10];

                double kcal;
                double proteinInGrams;
                double fatInGrams;
                double carbohydratesInGrams;
                double fiberInGrams;
                double solubleFiberInGrams;
                double insolubleFiberInGrams;
                double calciumInMilligrams;
                double sodiumInMilligrams;
                double saturatedFattyAcidsInGrams;
                double polyunsaturatedFattyAcidsInGrams;
                double monounsaturatedFattyAcidsInGrams;
                double cholesterolInMilligrams;
                double sugarInGrams;
                double addedSugarsInGrams;
                double alcoholInGrams;
                double caffeineInMilligrams;
                double ironInMilligrams;
                double potassiumInMilligrams;
                double phosphorusInMilligrams;
                double thiaminInMilligrams;
                double riboflavinInMilligrams;
                double niacinInMilligrams;
                double pantothenicAcidInMilligrams;
                double vitaminB6InMilligrams;
                double vitaminB12InMicrograms;
                double vitaminCInMilligrams;
                double folateInMicrograms;
                double vitaminAInInternationalUnits;
                double betaCaroteneInMicrograms;
                double lycopeneInMicrograms;
                double vitaminDInMicrograms;
                double vitaminEInInternationalUnits;
                Long nccFoodGroupCategoryId;
                Long commonPortionSizeDescriptionId;
                Long commonPortionSizeUnitId;


                // Check if any of the columns are empty, replace missing with zeros.
                if (foodInfo[12].isEmpty()) {
                    kcal = 0;
                } else {
                    kcal = Double.parseDouble(foodInfo[12]);
                }

                if (foodInfo[13].isEmpty()) {
                    proteinInGrams = 0;
                } else {
                    proteinInGrams = Double.parseDouble(foodInfo[13]);
                }

                if (foodInfo[17].isEmpty()) {
                    fatInGrams = 0;
                } else {
                    fatInGrams = Double.parseDouble(foodInfo[17]);
                }

                if (foodInfo[18].isEmpty()) {
                    carbohydratesInGrams = 0;
                } else {
                    carbohydratesInGrams = Double.parseDouble(foodInfo[18]);
                }

                if (foodInfo[20].isEmpty()) {
                    fiberInGrams = 0;
                } else {
                    fiberInGrams = Double.parseDouble(foodInfo[20]);
                }

                if (foodInfo[22].isEmpty()) {
                    solubleFiberInGrams = 0;
                } else {
                    solubleFiberInGrams = Double.parseDouble(foodInfo[22]);
                }

                if (foodInfo[21].isEmpty()) {
                    insolubleFiberInGrams = 0;
                } else {
                    insolubleFiberInGrams = Double.parseDouble(foodInfo[21]);
                }

                if (foodInfo[25].isEmpty()) {
                    calciumInMilligrams = 0;
                } else {
                    calciumInMilligrams = Double.parseDouble(foodInfo[25]);
                }

                if (foodInfo[30].isEmpty()) {
                    sodiumInMilligrams = 0;
                } else {
                    sodiumInMilligrams = Double.parseDouble(foodInfo[30]);
                }

                if (foodInfo[68].isEmpty()) {
                    saturatedFattyAcidsInGrams = 0;
                } else {
                    saturatedFattyAcidsInGrams = Double.parseDouble(foodInfo[68]);
                }

                if (foodInfo[86].isEmpty()) {
                    polyunsaturatedFattyAcidsInGrams = 0;
                } else {
                    polyunsaturatedFattyAcidsInGrams = Double.parseDouble(foodInfo[86]);
                }

                if (foodInfo[80].isEmpty()) {
                    monounsaturatedFattyAcidsInGrams = 0;
                } else {
                    monounsaturatedFattyAcidsInGrams = Double.parseDouble(foodInfo[80]);
                }

                if (foodInfo[103].isEmpty()) {
                    cholesterolInMilligrams = 0;
                } else {
                    cholesterolInMilligrams = Double.parseDouble(foodInfo[103]);
                }

                if (foodInfo[127].isEmpty()) {
                    sugarInGrams = 0;
                } else {
                    sugarInGrams = Double.parseDouble(foodInfo[127]);
                }

                if (foodInfo[126].isEmpty()) {
                    addedSugarsInGrams = 0;
                } else {
                    addedSugarsInGrams = Double.parseDouble(foodInfo[126]);
                }

                if (foodInfo[123].isEmpty()) {
                    alcoholInGrams = 0;
                } else {
                    alcoholInGrams = Double.parseDouble(foodInfo[123]);
                }

                if (foodInfo[124].isEmpty()) {
                    caffeineInMilligrams = 0;
                } else {
                    caffeineInMilligrams = Double.parseDouble(foodInfo[124]);
                }

                if (foodInfo[26].isEmpty()) {
                    ironInMilligrams = 0;
                } else {
                    ironInMilligrams = Double.parseDouble(foodInfo[26]);
                }

                if (foodInfo[29].isEmpty()) {
                    potassiumInMilligrams = 0;
                } else {
                    potassiumInMilligrams = Double.parseDouble(foodInfo[29]);
                }

                if (foodInfo[28].isEmpty()) {
                    phosphorusInMilligrams = 0;
                } else {
                    phosphorusInMilligrams = Double.parseDouble(foodInfo[28]);
                }

                if (foodInfo[36].isEmpty()) {
                    thiaminInMilligrams = 0;
                } else {
                    thiaminInMilligrams = Double.parseDouble(foodInfo[36]);
                }

                if (foodInfo[37].isEmpty()) {
                    riboflavinInMilligrams = 0;
                } else {
                    riboflavinInMilligrams = Double.parseDouble(foodInfo[37]);
                }

                if (foodInfo[38].isEmpty()) {
                    niacinInMilligrams = 0;
                } else {
                    niacinInMilligrams = Double.parseDouble(foodInfo[38]);
                }

                if (foodInfo[39].isEmpty()) {
                    pantothenicAcidInMilligrams = 0;
                } else {
                    pantothenicAcidInMilligrams = Double.parseDouble(foodInfo[39]);
                }

                if (foodInfo[40].isEmpty()) {
                    vitaminB6InMilligrams = 0;
                } else {
                    vitaminB6InMilligrams = Double.parseDouble(foodInfo[40]);
                }

                if (foodInfo[45].isEmpty()) {
                    vitaminB12InMicrograms = 0;
                } else {
                    vitaminB12InMicrograms = Double.parseDouble(foodInfo[45]);
                }

                if (foodInfo[35].isEmpty()) {
                    vitaminCInMilligrams = 0;
                } else {
                    vitaminCInMilligrams = Double.parseDouble(foodInfo[35]);
                }

                if (foodInfo[41].isEmpty()) {
                    folateInMicrograms = 0;
                } else {
                    folateInMicrograms = Double.parseDouble(foodInfo[41]);
                }

                if (foodInfo[46].isEmpty()) {
                    vitaminAInInternationalUnits = 0;
                } else {
                    vitaminAInInternationalUnits = Double.parseDouble(foodInfo[46]);
                }

                if (foodInfo[49].isEmpty()) {
                    betaCaroteneInMicrograms = 0;
                } else {
                    betaCaroteneInMicrograms = Double.parseDouble(foodInfo[49]);
                }

                if (foodInfo[52].isEmpty()) {
                    lycopeneInMicrograms = 0;
                } else {
                    lycopeneInMicrograms = Double.parseDouble(foodInfo[52]);
                }

                if (foodInfo[54].isEmpty()) {
                    vitaminDInMicrograms = 0;
                } else {
                    vitaminDInMicrograms = Double.parseDouble(foodInfo[54]);
                }

                if (foodInfo[57].isEmpty()) {
                    vitaminEInInternationalUnits = 0;
                } else {
                    vitaminEInInternationalUnits = Double.parseDouble(foodInfo[57]);
                }


                // Check if the category is already in the database
                // If it isn't, it is added to the database
                Optional<NccFoodGroupCategory> optionalNccFoodGroupCategory = nccFoodGroupCategoryRepository.findNccFoodGroupCategoryByCategory(nccFoodGroupCategory.replaceAll("\"", ""));
                if (!optionalNccFoodGroupCategory.isPresent()) {
                    NccFoodGroupCategory newNccFoodGroupCategory = NccFoodGroupCategory.builder()
                            .category(nccFoodGroupCategory.replaceAll("\"", ""))
                            .created(new Date())
                            .updated(new Date())
                            .build();
                    nccFoodGroupCategoryRepository.save(newNccFoodGroupCategory);
                }
                // Get the id for a given category
                optionalNccFoodGroupCategory = nccFoodGroupCategoryRepository.findNccFoodGroupCategoryByCategory(nccFoodGroupCategory.replaceAll("\"", ""));
                NccFoodGroupCategory storedNccFoodGroupCategory = optionalNccFoodGroupCategory.get();
                nccFoodGroupCategoryId = storedNccFoodGroupCategory.getId();


                // Check if the description is already in the database
                // If it isn't, it is added to the database
                Optional<CommonPortionSizeDescription> optionalCommonPortionSizeDescription = commonPortionSizeDescriptionRepository.findCommonPortionSizeDescriptionByDescription(commonPortionSizeDescription);
                if (!optionalCommonPortionSizeDescription.isPresent()) {
                    CommonPortionSizeDescription newCommonPortionSizeDescription = CommonPortionSizeDescription.builder()
                            .description(commonPortionSizeDescription)
                            .created(new Date())
                            .updated(new Date())
                            .build();
                    commonPortionSizeDescriptionRepository.save(newCommonPortionSizeDescription);
                }
                // Get the id for a given description
                optionalCommonPortionSizeDescription = commonPortionSizeDescriptionRepository.findCommonPortionSizeDescriptionByDescription(commonPortionSizeDescription);
                CommonPortionSizeDescription storedCommonPortionSizeDescription = optionalCommonPortionSizeDescription.get();
                commonPortionSizeDescriptionId = storedCommonPortionSizeDescription.getId();


                // Check if the unit is already in the database
                // If it isn't, it is added to the database
                Optional<CommonPortionSizeUnit> optionalCommonPortionSizeUnit = commonPortionSizeUnitRepository.findCommonPortionSizeUnitByUnit(commonPortionSizeUnit);
                if (!optionalCommonPortionSizeUnit.isPresent()) {
                    CommonPortionSizeUnit newCommonPortionSizeUnit = CommonPortionSizeUnit.builder()
                            .unit(commonPortionSizeUnit)
                            .created(new Date())
                            .updated(new Date())
                            .build();
                    commonPortionSizeUnitRepository.save(newCommonPortionSizeUnit);
                }
                // Get the id for a given unit
                optionalCommonPortionSizeUnit = commonPortionSizeUnitRepository.findCommonPortionSizeUnitByUnit(commonPortionSizeUnit);
                CommonPortionSizeUnit storedCommonPortionSizeUnit = optionalCommonPortionSizeUnit.get();
                commonPortionSizeUnitId = storedCommonPortionSizeUnit.getId();


                // Check if the food is already in the database
                // If it isn't, it is added to the database
                Optional<Food> optionalFood = foodRepository.findFoodByBaseIdAndCommonPortionSizeUnitId(baseId, commonPortionSizeUnitId);
                if (!optionalFood.isPresent()) {
                    // Save the new food item to the database with the appropriate category id
                    Food newFood = Food.builder()
                            .baseId(baseId)
                            .keylist(keylist)
                            .description(description)
                            .foodType(foodType)
                            .nccFoodGroupCategoryId(nccFoodGroupCategoryId)
                            .kcal(kcal)
                            .proteinInGrams(proteinInGrams)
                            .fatInGrams(fatInGrams)
                            .carbohydratesInGrams(carbohydratesInGrams)
                            .fiberInGrams(fiberInGrams)
                            .solubleFiberInGrams(solubleFiberInGrams)
                            .insolubleFiberInGrams(insolubleFiberInGrams)
                            .calciumInMilligrams(calciumInMilligrams)
                            .sodiumInMilligrams(sodiumInMilligrams)
                            .saturatedFattyAcidsInGrams(saturatedFattyAcidsInGrams)
                            .polyunsaturatedFattyAcidsInGrams(polyunsaturatedFattyAcidsInGrams)
                            .monounsaturatedFattyAcidsInGrams(monounsaturatedFattyAcidsInGrams)
                            .cholesterolInMilligrams(cholesterolInMilligrams)
                            .sugarInGrams(sugarInGrams)
                            .addedSugarsInGrams(addedSugarsInGrams)
                            .alcoholInGrams(alcoholInGrams)
                            .caffeineInMilligrams(caffeineInMilligrams)
                            .ironInMilligrams(ironInMilligrams)
                            .potassiumInMilligrams(potassiumInMilligrams)
                            .phosphorusInMilligrams(phosphorusInMilligrams)
                            .thiaminInMilligrams(thiaminInMilligrams)
                            .riboflavinInMilligrams(riboflavinInMilligrams)
                            .niacinInMilligrams(niacinInMilligrams)
                            .pantothenicAcidInMilligrams(pantothenicAcidInMilligrams)
                            .vitaminB6InMilligrams(vitaminB6InMilligrams)
                            .vitaminB12InMicrograms(vitaminB12InMicrograms)
                            .vitaminCInMilligrams(vitaminCInMilligrams)
                            .folateInMicrograms(folateInMicrograms)
                            .vitaminAInInternationalUnits(vitaminAInInternationalUnits)
                            .betaCaroteneInMicrograms(betaCaroteneInMicrograms)
                            .lycopeneInMicrograms(lycopeneInMicrograms)
                            .vitaminDInMicrograms(vitaminDInMicrograms)
                            .vitaminEInInternationalUnits(vitaminEInInternationalUnits)
                            .commonPortionSizeAmount(commonPortionSizeAmount)
                            .commonPortionSizeGramWeight(commonPortionSizeGramWeight)
                            .commonPortionSizeDescriptionId(commonPortionSizeDescriptionId)
                            .commonPortionSizeUnitId(commonPortionSizeUnitId)
                            .created(new Date())
                            .updated(new Date())
                            .build();
                    foodRepository.save(newFood);
                }
            }
            System.out.println("DATA INSERTION COMPLETE");
            return "file successfully uploaded";
        } catch (Exception e) {
            return "error";
        }
    }

}

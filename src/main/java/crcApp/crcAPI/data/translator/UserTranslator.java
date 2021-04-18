package crcApp.crcAPI.data.translator;


import crcApp.crcAPI.data.model.User;
import crcApp.crcAPI.data.service.UserService;
import crcApp.crcAPI.web.models.UserView;

import java.util.ArrayList;
import java.util.List;

public class UserTranslator {
    public static UserView entityToView(final User user) {
        Boolean[] giIssues = UserService.getUserFrequentGiIssues(user.getId());
        Boolean[] cancerTreatment = UserService.getCancerTreatment(user.getId());


        return UserView.builder()
                .dateOfBirth(user.getDateOfBirth())
                .race(user.getRace())
                .ethnicity(user.getEthnicity())
                .gender((user.getGender()))
                .height(user.getHeight())
                .weight(user.getWeight())
                .fatPercent(user.getFatPercent())
                .proteinPercent(user.getProteinPercent())
                .carbohydratePercent(user.getCarbohydratePercent())
                .activityLevel(UserService.getActivityLevel(user.getActivityLevelId()))
                .abdominalPain(giIssues[0])
                .appetiteLoss(giIssues[1])
                .bloating(giIssues[2])
                .constipation(giIssues[3])
                .diarrhea(giIssues[4])
                .nausea(giIssues[5])
                .stomaProblems(giIssues[6])
                .colorectal(user.getColorectal())
                .stage(user.getStage())
                .diagnosisDate(user.getDiagnosisDate())
                .surgery(cancerTreatment[0])
                .chemo(cancerTreatment[1])
                .radiation(cancerTreatment[2])
                .other(cancerTreatment[3])
                .uncertain(cancerTreatment[4])
                .ostomy(cancerTreatment[5])
                .build();
    }

    public static ArrayList<UserView> entitiesToView(List<User> users) {
        ArrayList<UserView> userViews = new ArrayList<>();
        for (User user : users) {
            Boolean[] giIssues = UserService.getUserFrequentGiIssues(user.getId());
            Boolean[] cancerTreatment = UserService.getCancerTreatment(user.getId());
            userViews.add(UserView.builder()
                    .dateOfBirth(user.getDateOfBirth())
                    .race(user.getRace())
                    .ethnicity(user.getEthnicity())
                    .gender((user.getGender()))
                    .height(user.getHeight())
                    .weight(user.getWeight())
                    .fatPercent(user.getFatPercent())
                    .proteinPercent(user.getProteinPercent())
                    .carbohydratePercent(user.getCarbohydratePercent())
                    .activityLevel(UserService.getActivityLevel(user.getActivityLevelId()))
                    .abdominalPain(giIssues[0])
                    .appetiteLoss(giIssues[1])
                    .bloating(giIssues[2])
                    .constipation(giIssues[3])
                    .diarrhea(giIssues[4])
                    .nausea(giIssues[5])
                    .stomaProblems(giIssues[6])
                    .colorectal(user.getColorectal())
                    .stage(user.getStage())
                    .diagnosisDate(user.getDiagnosisDate())
                    .surgery(cancerTreatment[0])
                    .chemo(cancerTreatment[1])
                    .radiation(cancerTreatment[2])
                    .other(cancerTreatment[3])
                    .uncertain(cancerTreatment[4])
                    .ostomy(cancerTreatment[5])
                    .build());
        }
        return userViews;


    }


}

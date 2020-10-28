public class goals {
    public String getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(String targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getTargetcalories() {
        return targetcalories;
    }

    public void setTargetcalories(String targetcalories) {
        this.targetcalories = targetcalories;
    }

    public String getDailyWeight() {
        return dailyWeight;
    }

    public void setDailyWeight(String dailyWeight) {
        this.dailyWeight = dailyWeight;
    }

    String targetWeight, targetcalories, dailyWeight;

    public goals(String targetWeight, String targetcalories, String dailyWeight) {
        this.targetWeight = targetWeight;
        this.targetcalories = targetcalories;
        this.dailyWeight = dailyWeight;
    }
}

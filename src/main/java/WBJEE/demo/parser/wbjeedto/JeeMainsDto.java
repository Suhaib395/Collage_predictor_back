package WBJEE.demo.parser.wbjeedto;

public class JeeMainsDto {
    String institute;

    String program;

    String quota;

    String seatType;

    String gender;

    String openingRank;

    String closingRank;

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOpeningRank() {
        return openingRank;
    }

    public void setOpeningRank(String openingRank) {
        this.openingRank = openingRank;
    }

    public String getClosingRank() {
        return closingRank;
    }

    public void setClosingRank(String closingRank) {
        this.closingRank = closingRank;
    }

    @Override
    public String toString() {
        return "JeeMainsDto{" +
                "institute='" + institute + '\'' +
                ", program='" + program + '\'' +
                ", quota='" + quota + '\'' +
                ", seatType='" + seatType + '\'' +
                ", gender='" + gender + '\'' +
                ", openingRank='" + openingRank + '\'' +
                ", closingRank='" + closingRank + '\'' +
                '}';
    }
}

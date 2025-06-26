package WBJEE.demo.parser.wbjeedto;


//define fileld here


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class WbjeeDto {

    String srNo;

    String round;

    String institute;

    String course;

    String stream;

    String seatType;

    String quota;

    String Category;

    String openingRank;

    String closingRank;

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getopeningRank() {
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
        return "WbjeeDto{" +
                "srNo='" + srNo + '\'' +
                ", round='" + round + '\'' +
                ", institute='" + institute + '\'' +
                ", course='" + course + '\'' +
                ", stream='" + stream + '\'' +
                ", seatType='" + seatType + '\'' +
                ", quota='" + quota + '\'' +
                ", Category='" + Category + '\'' +
                ", openingRank='" + openingRank + '\'' +
                ", closingRank='" + closingRank + '\'' +
                '}';
    }
}


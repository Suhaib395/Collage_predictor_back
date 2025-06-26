package WBJEE.demo.utility;

import WBJEE.demo.parser.wbjeedto.WbjeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Util {
    public List<WbjeeDto> predictWbjee(
            String instituteName,
            String seatType,
            String maxClosingRank,
            String course,
            String stream,
            String quota,
            String category,
            String round,
            List<WbjeeDto> Alldata) {


        return Alldata.stream()
                .filter(data -> round == null || data.getRound().toLowerCase().contains(round.toLowerCase()))
                .filter(data -> instituteName == null || data.getInstitute().toLowerCase().contains(instituteName.toLowerCase()))
                .filter(data -> seatType == null || data.getSeatType().toLowerCase().contains(seatType.toLowerCase()))
                .filter(data -> course == null || data.getCourse().toLowerCase().contains(course.toLowerCase()))
                .filter(data -> maxClosingRank == null || Integer.parseInt ( data.getClosingRank() )>=Integer.parseInt( maxClosingRank))
                .filter(data -> stream == null || data.getStream().toLowerCase().contains(stream.toLowerCase()))
                .filter(data -> quota == null || data.getQuota().toLowerCase().contains(quota.toLowerCase()))
                .filter(data -> category == null || data.getCategory().toLowerCase().contains(category.toLowerCase()))
                .collect(Collectors.toList());
    }

}

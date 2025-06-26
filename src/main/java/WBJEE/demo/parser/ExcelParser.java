package WBJEE.demo.parser;


import WBJEE.demo.parser.wbjeedto.JeeMainsDto;
import WBJEE.demo.parser.wbjeedto.WbjeeDto;
import WBJEE.demo.utility.Util;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExcelParser {

//    public static List<WbjeeDto> readUsersFromCSV(String filePath) throws Exception {
//        try (Reader reader = new FileReader(filePath)) {
//            CsvToBean<WbjeeDto> csvToBean = new CsvToBeanBuilder<WbjeeDto>(reader)
//                    .withType(WbjeeDto.class)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .withIgnoreQuotations(true).withSkipLines(1)
//                    .build();
//            return csvToBean.parse();
//        }
//    }

    public static List<JeeMainsDto> readUsersFromCSVForJEE(String filePath)  {

        //String filePath="D:\\Suhaib Arshad\\Wbjee-2025\\archive\\wbjeeorcr_2024_test.csv";
        List<JeeMainsDto>finalList=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Splitting by comma
                JeeMainsDto jeeMainsDto=new JeeMainsDto();
                jeeMainsDto.setInstitute(values[0]);
                jeeMainsDto.setProgram(values[1]);
                jeeMainsDto.setQuota(values[2]);
                jeeMainsDto.setSeatType(values[3]);
                jeeMainsDto.setGender(values[4]);
                jeeMainsDto.setOpeningRank(values[5]);
                jeeMainsDto.setClosingRank(values[6]);
                finalList.add(jeeMainsDto);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalList;
    }


    //to get all data from csv for Wbjee
    public static List<WbjeeDto> readUsersFromCSVForWbjee(String filePath)  {

        //String filePath="D:\\Suhaib Arshad\\Wbjee-2025\\archive\\wbjeeorcr_2024_test.csv";
        List<WbjeeDto>finalList=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(","); // Splitting by comma
                    WbjeeDto wbjeeDto=new WbjeeDto();
                    wbjeeDto.setSrNo(values[0]);
                    wbjeeDto.setRound(values[1]);
                    wbjeeDto.setInstitute(values[2]);
                    wbjeeDto.setCourse(values[3]);
                    wbjeeDto.setStream(values[4]);
                    wbjeeDto.setSeatType(values[5]);
                    wbjeeDto.setQuota(values[6]);
                    wbjeeDto.setCategory(values[7]);
                    wbjeeDto.setOpeningRank(values[8]);
                    wbjeeDto.setClosingRank(values[9]);
                    finalList.add(wbjeeDto);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalList;
    }

//{srNo='1', round='Round 1', institute='Calcutta Institute of Technology Uluberia Howrah',
// program='Mechanical Engineering', stream='B.E/B.Tech (WBJEE/JEE(Main) Seats)/B.Arch (WBJEE Seats)',
// seatType='WBJEE Seats', quota='All India', Category='Open', openingRank='52973', closingRank='88134'}


    //find data by Round and Stream and category
    public static List<WbjeeDto> filterDataBasedOnRoundAndProgramAndCategoryAndSeatTypeAndrank(String round,String program,String category,String seatType,String rank,List<WbjeeDto> fulldata){
        List<WbjeeDto> filterdata=new ArrayList<>();

        for(var val:fulldata){
            if(val.getRound().contains(round) && val.getCourse().toLowerCase().contains(program.toLowerCase()) && val.getCategory().toLowerCase().contains(category.toLowerCase())&& val.getSeatType().toLowerCase().contains(seatType.toLowerCase())){
                if(Integer.parseInt(val.getClosingRank())>Integer.parseInt(rank))
                    filterdata.add(val);

                //System.out.println("inside=============================");
            }
           // System.out.println(val.getCategory().toLowerCase().equals(category.toLowerCase())+"+++++++++++++++++++++");
        }


        return filterdata;
    }

    public static List<JeeMainsDto> filterDataBasedOnProgramAndrank(String program,String rank,List<JeeMainsDto> fulldata){
        List<JeeMainsDto> filterdata=new ArrayList<>();
        //System.out.println(fulldata.size()+"===============");
        //val.getProgram().toLowerCase().contains(program.toLowerCase()) &&
        try {
            for (var val : fulldata) {
                if ( val.getSeatType().contains("EWS")) {
                    if (!val.getClosingRank().contains("P") && Integer.parseInt(val.getClosingRank()) > (Integer.parseInt(rank))) {
                        filterdata.add(val);
                    }


                }

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return filterdata;
    }


    public static void main(String[] args) {
        //String filePath="D:\\Suhaib Arshad\\Wbjee-2025\\wbjeeorcr_2022.csv";
        String filePath="./src/main/resources/data/wbjeeorcr_2022.csv";
        System.out.println("filepath = ====================="+filePath);
        try {
           List<WbjeeDto> fulldata= readUsersFromCSVForWbjee(filePath);
           // System.out.println("fulldata="+fulldata);
//            List<WbjeeDto> result=filterDataBasedOnRoundAndProgramAndCategoryAndSeatTypeAndrank("3","computer","open","jee","400000",fulldata);
//            result.sort(Comparator.comparingInt((WbjeeDto dto)->Integer.parseInt(dto.getClosingRank())));
//            for(var val:result){
//                System.out.println(val.getRound()+" "+val.getInstitute()+" "+val.getProgram()+" "+val.getopeningRank()+"---"+val.getClosingRank());
//            }

//============================================================================================================
           // for jee advance
//            List<JeeMainsDto> fulldata= readUsersFromCSVForJEE(filePath);
//            //System.out.println(fulldata);
//            List<JeeMainsDto> result=filterDataBasedOnProgramAndrank("computer","20000",fulldata);
//            //System.out.println(result);
//           result.sort(Comparator.comparingInt((JeeMainsDto dto)->Integer.parseInt(dto.getClosingRank())));
//            for(var val:result){
//                //System.out.println(val.getGender()+"---->"+val.getInstitute()+" "+val.getProgram()+" "+val.getOpeningRank()+"---"+val.getClosingRank());
//                System.out.println(val);
//            }
// ============================================================================================================
            ///stream testing
//            predictWbjee(
//                    String instituteName,
//                    String seatType,
//                    String maxClosingRank,
//                    String program,
//                    String stream,
//                    String quota,
//                    String category,
//                    List<WbjeeDto> Alldata)

            //data:-//{srNo='1', round='Round 1', institute='Calcutta Institute of Technology Uluberia Howrah',
            //// program='Mechanical Engineering', stream='B.E/B.Tech (WBJEE/JEE(Main) Seats)/B.Arch (WBJEE Seats)',
            //// seatType='WBJEE Seats', quota='All India', Category='Open', openingRank='52973', closingRank='88134'}

            Util obj=new Util();
            List<WbjeeDto> result=obj.predictWbjee(null,"WBJEE Seats","14","Chemical Engineering",null,null,null,"Round 2",fulldata);
            //System.out.println("result ====="+result);
            result.sort(Comparator.comparingInt((WbjeeDto dto)->Integer.parseInt(dto.getClosingRank())));
            for(var val:result){
                //System.out.println(val.getGender()+"---->"+val.getInstitute()+" "+val.getProgram()+" "+val.getOpeningRank()+"---"+val.getClosingRank());
                System.out.println(val);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }
}

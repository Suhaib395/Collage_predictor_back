package WBJEE.demo.controller;


import WBJEE.demo.parser.ExcelParser;
import WBJEE.demo.parser.wbjeedto.WbjeeDto;
import WBJEE.demo.utility.Util;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/wbjee")
@CrossOrigin("*")
public class WbjeeController {

    List<List<WbjeeDto>> fulldata=new ArrayList<>();

    @PostConstruct
    public void init() {
        List<String> filePaths = new ArrayList<>();
//        filePaths.add("D:\\Suhaib Arshad\\Wbjee-2025\\wbjeeorcr_2021.csv");
//        filePaths.add("D:\\Suhaib Arshad\\Wbjee-2025\\wbjeeorcr_2022.csv");
//        filePaths.add("D:\\Suhaib Arshad\\Wbjee-2025\\wbjeeorcr_2023.csv");
//        filePaths.add("D:\\Suhaib Arshad\\Wbjee-2025\\wbjeeorcr_2024.csv");
        filePaths.add("./src/main/resources/data/wbjeeorcr_2021.csv");
        filePaths.add("./src/main/resources/data/wbjeeorcr_2022.csv");
        filePaths.add("./src/main/resources/data/wbjeeorcr_2023.csv");
        filePaths.add("./src/main/resources/data/wbjeeorcr_2024.csv");
        //String filePath="D:\\Suhaib Arshad\\Wbjee-2025\\jee\\jee_2024_round_5.csv";
        List<List<WbjeeDto>> allData=new ArrayList<>();
        for(var filePath:filePaths) {
            System.out.println("filepath==="+filePath);
            List<WbjeeDto> data = ExcelParser.readUsersFromCSVForWbjee(filePath);
            allData.add(data);
        }
        this.fulldata=allData;
        //System.out.println("inintit========"+fulldata.size());
    }

    @Autowired
    private Util util;

    @GetMapping("/predict")
    public List<WbjeeDto> predictWbjee(
            @RequestParam(required = false) String instituteName,
            @RequestParam(required = false) String seatType,
            @RequestParam(required = false) String maxClosingRank,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String stream,
            @RequestParam(required = false) String quota,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String round,
            @RequestParam(required = false) String year
    ) {
        List<List<WbjeeDto>> data = fulldata; // all Excel data
        System.out.println("year="+year);

        System.out.println("instituteName="+instituteName+" seatType="+seatType+" maxClosingRank="+maxClosingRank+" course="+course+" stream="+stream+" quota="+quota+" category="+category+" round="+round);
        int index=0;
        if(year!=null)
         index=Integer.parseInt(year)-2021;

        System.out.println("============================"+index);
        List<WbjeeDto> result=util.predictWbjee(
                instituteName, seatType, maxClosingRank, course,
                stream, quota, category, round, data.get(index)
        );
        result.sort(Comparator.comparingInt((WbjeeDto dto)->Integer.parseInt(dto.getClosingRank())));
        return result;
    }
}

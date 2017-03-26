package org.nero.click.data.utils;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/7
 * Time   下午4:32
 */
public class TTest {


//    ttest: function(data, gene1, gene2, alpha, times) {
//        var ttestdata = [];
//        data.forEach(function(a) {
//            a.forEach(function(b) {
//                b.forEach(function(c) {
//                    ttestdata.push(c);
//                });
//            });
//        });
//
//        var s1 = 0;
//        var s2 = 0;
//        var x1 = 0;
//        var x2 = 0;
//
//        ttestdata[gene1].forEach(function(x) {
//            x1 = (x1 + x[1]) / 2;
//            s1 += x[1];
//        });
//        ttestdata[gene2].forEach(function(x) {
//            s2 += x[1];
//            x2 = (x2 + x[1]) / 2;
//        });
//
//        return (x1 - x2 - alpha) / Math.sqrt(s1 ^ 2 / ttestdata[gene1].length, s2 ^ 2 / ttestdata[gene2].length);
//
//    },


    public static Double test(List<Double> data1,List<Double> data2){
        //和
        Double s1 = 0.0;
        Double s2 = 0.0;
        //均值
        Double x1 = 0.0;
        Double x2 = 0.0;
        //方差
        Double f1 = 0.0;
        Double f2 = 0.0;


        for(Double a:data1){
            s1 += a;
        }
        x1 = s1/data1.size();
        for(Double b:data1){
            s2 += b;
        }
        x2 = s2/data2.size();

        Double ss1 = 0.0;
        for(Double a:data1){
            ss1+=Math.pow(x1-a,2);
        }
        f1 = ss1/data1.size();

        Double ss2 = 0.0;
        for(Double b:data2){
            ss2+=Math.pow(x2-b,2);
        }
        f2 = ss2/data2.size();

        Double p = (x1-x2) / Math.sqrt(
                (
                        (
                                (data1.size()-1)*f1+(data2.size()-1)*f2
                        ) / (
                                data1.size()+data2.size()-2
                        )
                ) *(1/data1.size()+1/data2.size())
        );

        return p;
    }

}

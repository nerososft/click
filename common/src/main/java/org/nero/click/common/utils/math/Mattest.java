package org.nero.click.common.utils.math;

import com.mathworks.toolbox.javabuilder.MWException;
import mymattest.mymattestclass;

import java.util.List;

/**
 * Created by Whishou on 2017/5/1.
 * Email: whishoutan@gmail.com
 */
public class Mattest {
    public static Object mattest(List<Float> x, List<Float> y) throws MWException {
        Object result[]=null;
        try{
            int size1=x.size();
            int size2=y.size();
            Float[] a=new Float[size1];
            Float[] b=new Float[size2];
            for(int i=0;i<size1;i++){
                a[i]=x.get(i);
            }
            for(int i=0;i<size2;i++){
                b[i]=y.get(i);
            }
            mymattestclass myMattest=new mymattestclass();
            result = myMattest.mymattest(1,a,b);
            System.out.println(result[0]);
            return result[0];
        }catch (MWException e){
            throw e;
        }
    }
}

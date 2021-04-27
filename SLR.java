import java.util.ArrayList;
import java.lang.Math;

public class SLR{

    ArrayList<Integer> ds_X=new ArrayList<Integer>(); //Advertising
    ArrayList<Integer> ds_Y=new ArrayList<Integer>(); //Sales

    public SLR(){
            addData();
    }

    public double betaUno(){    // se calcula beta uno
            double result=0;
            double numerator=0;
            double denominator=0;
            numerator=ds_X.size()*sumXiYi()-sumXi()*sumYi();
            denominator=ds_X.size()*sumPowerXi()-sumXi()*sumXi();
            result=numerator/denominator;

            return result;
    }
    public double betaZero(){    // se calcula beta cero
            double result=0;
            double numerator=0;
            double denominator=0;
            numerator=sumPowerXi()*sumYi()-sumXi()*sumXiYi();
            denominator=ds_X.size()*sumPowerXi()-sumXi()*sumXi();
            result=numerator/denominator;
            return result;
    }
    public int sumXiYi(){    // sumatoria de XY
        int val=0;
        for(int i=0;i<ds_X.size();i++){
            val+=ds_X.get(i)*ds_Y.get(i);
        }
        return val;

    }
    public int sumXi(){     // sumatoria de X
        int val=0;
        for(int i=0;i<ds_X.size();i++){
            val+=ds_X.get(i);
        }
        return val;
    }
    public int sumYi(){     // sumatoria de Y
        int val=0;
        for(int i=0;i<ds_Y.size();i++){
            val+=ds_Y.get(i);
        }
        return val;
    }
    public int sumPowerXi(){      //sumatoria de X al cuadrado
        int val=0;
        for(int i=0;i<ds_X.size();i++){
            val+=(int)Math.pow(ds_X.get(i),2);
        }
        return val;
    }
    public void addData(){ // metodo para añadir los datos al arreglo de X y Y

        ds_Y.add(651);
        ds_Y.add(762);
        ds_Y.add(856);
        ds_Y.add(1063);
        ds_Y.add(1190);
        ds_Y.add(1298);
        ds_Y.add(1421);
        ds_Y.add(1440);
        ds_Y.add(1518);

        ds_X.add(23);
        ds_X.add(26);
        ds_X.add(30);
        ds_X.add(34);
        ds_X.add(43);
        ds_X.add(48);
        ds_X.add(52);
        ds_X.add(57);
        ds_X.add(58);
    }

public static void main(String[] varx){
        double dt0=0;
        double dt1=0;
        double pre=0;
        SLR obj1=new SLR();

        System.out.println("  X        Y        XY        X^2");
        System.out.println("  "+obj1.sumXi()+"      "+obj1.sumYi()+"    "+obj1.sumXiYi()+"    "+obj1.sumPowerXi()+"\n");


        dt0=obj1.betaZero();
        dt1=obj1.betaUno();
        System.out.println("  Y = B0 + B1x  \n  Y = "+(double)dt0+" + "+(double)dt1+"("+varx[0]+")\n");
        pre=dt0+(dt1*Double.valueOf(varx[0]));
        System.out.println("  y "+pre+"\n");
}

}

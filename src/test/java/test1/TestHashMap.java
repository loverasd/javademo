package test1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Classname TestHashMap
 * @Description TODO
 * @Date 2019-06-23 22:31
 * @Created by chenpan
 */
public class TestHashMap {
    public static void main(String[] args) {

        ArrayList<String> riskInfo = new ArrayList<>();
        HashMap<String, ArrayList<String>> planInfo = new HashMap<>();
        PlanInfo planInfo1 = new PlanInfo("a", "riskinfo1", "a3");
        PlanInfo planInfo2 = new PlanInfo("a", "riskinfo2", "a23");
        PlanInfo planInfo3 = new PlanInfo("b", "risinfo3", "a33");
        PlanInfo planInfo4 = new PlanInfo("c", "riskinfo4", "a43");
        PlanInfo planInfo5 = new PlanInfo("d", "riskinfo5", "a53");

        ArrayList<PlanInfo> planInfos = new ArrayList<>();
        planInfos.add(planInfo1);
        planInfos.add(planInfo2);
        planInfos.add(planInfo3);
        planInfos.add(planInfo4);
        planInfos.add(planInfo5);
        ArrayList<String> arrayList = null;

        for (PlanInfo planI :
                planInfos) {
            if (planInfo.containsKey(planI.a)) {
                arrayList = planInfo.get("a");
            } else {
                arrayList = new ArrayList<>();
                planInfo.put(planI.a, arrayList);
            }

            arrayList.add(planI.b);

        }
        ;
        planInfo.forEach((a, b) -> {
            System.out.println(a + ":" + b.stream().count());
        });
        /*while (planInfos.iterator().hasNext()){
            PlanInfo planI = planInfos.iterator().next();
            if (planInfo.containsKey(planI.a)){
                arrayList = planInfo.get("a");
            }else {
                arrayList = new ArrayList<>();
                planInfo.put(planI.a,arrayList);
            }

            arrayList.add(planI.b);*/


//            String planiNfo = "A";
//            ArrayList<String> arrayList = null;
//            if (planInfo.containsKey("A")) {
//               arrayList = planInfo.get("A");
//            }else {
//                arrayList = new ArrayList<>();
//                planInfo.put("plancode",arrayList);
//            }
//
//            arrayList.add("RiskInfo");
//

//        }


    }
}

class PlanInfo {
    public PlanInfo(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    String a;
    String b;
    String c;
}

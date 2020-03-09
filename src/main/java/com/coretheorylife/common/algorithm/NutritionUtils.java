package com.coretheorylife.common.algorithm;

import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Connor
 * 身体健康数据计算提供类
 */
@Component
public class NutritionUtils {

    public static final int SPORT_TYPE_LOSS_FAT = 1;

    public static final int SPORT_TYPE_GAIN_MUSCLE = 2;

    public static final int SPORT_TYPE_KEEP = 3;

    @Autowired
    private TPurchaserHealthExamService tPurchaserHealthExamService;

    /**
     * 减肥
     * @param base   行为代谢
     * @param fats   需要减脂多少
     * @param weight 体重
     * @return
     */
    public BigDecimal fatLoss(BigDecimal base, BigDecimal fats, BigDecimal weight, boolean man, int age) {
        BigDecimal needProteinKacl = getProtein(weight, SPORT_TYPE_LOSS_FAT).multiply(new BigDecimal("4"));
        BigDecimal needCarbohydrateKacl = getCarbohydrate(weight, SPORT_TYPE_LOSS_FAT).multiply(new BigDecimal("4"));
        //总需摄入
        BigDecimal allInKacl = needProteinKacl.add(needCarbohydrateKacl);
        BigDecimal baseNeed = getBaseNeedKcal(base, weight, man, age);
        return new BigDecimal("7700").divide(baseNeed.subtract(allInKacl), 3, BigDecimal.ROUND_HALF_UP).multiply(fats);
    }

    /**
     * 获取每天需要的卡路里
     * @param base
     * @param weight
     * @param man
     * @param age
     * @return
     */
    public BigDecimal getBaseNeedKcal(BigDecimal base, BigDecimal weight, boolean man, int age) {
        BigDecimal baseNeed = getREE(age, weight, man, null).multiply(BigDecimal.ONE.add(base)).add(new BigDecimal("200"));
        return baseNeed;
    }

    public static BigDecimal getKcl(BigDecimal protein, BigDecimal fat, BigDecimal carbohydrate) {
        BigDecimal kcl = BigDecimal.ZERO;
        if (protein != null) {
            kcl = kcl.add(protein.multiply(new BigDecimal(4)));
        }
        if (carbohydrate != null) {
            kcl = kcl.add(carbohydrate.multiply(new BigDecimal(4)));
        }
        if (fat != null) {
            kcl = kcl.add(fat.multiply(new BigDecimal(9)));
        }
        return kcl;
    }

    /**
     * 获取基础代谢
     * @param age
     * @param weight
     * @param man
     * @return
     */
    public BigDecimal getREE(int age, BigDecimal weight, boolean man, Long purchaserId) {
        if (purchaserId != null) {
            TPurchaserHealthExam tPurchaserHealthExam = tPurchaserHealthExamService.queryObjectByPurchaserId(purchaserId);
            if (tPurchaserHealthExam != null && tPurchaserHealthExam.getBasalMetabolism() != null && tPurchaserHealthExam.getBasalMetabolism().compareTo(BigDecimal.ZERO) == 1) {
                return tPurchaserHealthExam.getBasalMetabolism();
            }
        }
        if (man) {
            if (age <= 9) {
                return new BigDecimal("22.7").multiply(weight).add(new BigDecimal("495"));
            } else if (age <= 17) {
                return new BigDecimal("17.5").multiply(weight).add(new BigDecimal("651"));
            } else if (age <= 29) {
                return new BigDecimal("15.3").multiply(weight).add(new BigDecimal("679"));
            } else if (age <= 60) {
                return new BigDecimal("11.6").multiply(weight).add(new BigDecimal("879"));
            } else {
                return new BigDecimal("13.5").multiply(weight).add(new BigDecimal("487"));
            }
        } else {
            if (age <= 9) {
                return new BigDecimal("22.5").multiply(weight).add(new BigDecimal("499"));
            } else if (age <= 17) {
                return new BigDecimal("12.2").multiply(weight).add(new BigDecimal("746"));
            } else if (age <= 29) {
                return new BigDecimal("14.7").multiply(weight).add(new BigDecimal("496"));
            } else if (age <= 60) {
                return new BigDecimal("8.7").multiply(weight).add(new BigDecimal("829"));
            } else {
                return new BigDecimal("10.5").multiply(weight).add(new BigDecimal("596"));
            }
        }
    }

    /**
     * 获取理想身高
     * 身高 cm
     * 男女
     *
     * @param height
     * @return
     */
    public static BigDecimal getDreamWeight(BigDecimal height) {
        return new BigDecimal("0.0022").multiply(height.multiply(height));
    }

    /**
     * 体测用户 获取标准体脂
     * @param weight
     * @param man
     * @return
     */
    public static BigDecimal getDreamFat(BigDecimal weight, boolean man) {
        if (man) {
            return new BigDecimal("0.15").multiply(weight);
        } else {
            return new BigDecimal("22").multiply(weight);
        }
    }

    /**
     * 获取蛋白质的卡路里
     * 注意，体重的单位是kg，需要摄入蛋白的单位为g/kg/天
     * 运动类型123对应减脂增肌和维持
     *
     * @param weight
     * @return
     */
    public static BigDecimal getProtein(BigDecimal weight, int sportType) {
        switch (sportType) {
            case SPORT_TYPE_LOSS_FAT:
                return weight.multiply(new BigDecimal("1.5"));
            case SPORT_TYPE_GAIN_MUSCLE:
                return weight.multiply(new BigDecimal("1.9"));
            case SPORT_TYPE_KEEP:
                return weight.multiply(new BigDecimal("1.5"));
            default:
                return BigDecimal.ZERO;
        }
    }

    /**
     * 获取碳水的卡路里
     *
     * 注意，体重的单位是kg，需要摄入蛋白的单位为g/kg/天
     * 运动类型123对应减脂增肌和维持
     *
     * @param weight
     * @return
     */
    public static BigDecimal getCarbohydrate(BigDecimal weight, int sportType) {
        switch (sportType) {
            case SPORT_TYPE_LOSS_FAT:
                return weight.multiply(new BigDecimal("3"));
            case SPORT_TYPE_GAIN_MUSCLE:
                return weight.multiply(new BigDecimal("7"));
            case SPORT_TYPE_KEEP:
                return weight.multiply(new BigDecimal("5"));
            default:
                return BigDecimal.ZERO;
        }
    }

    public static void main(String args[]) {
//        System.out.println("减脂");
//        BigDecimal result = getDreamWeight(new BigDecimal("171"));
//        System.out.println("身高171cm 理想体重为 " + result + "kg");
//
//        result = fatLoss(new BigDecimal("0.4"), new BigDecimal("80").subtract(getDreamWeight(new BigDecimal("171"))), new BigDecimal("80"), true, 25);
//        System.out.println("身高171cm 80kg 25岁男性 行为代谢0.4 达到理想体重需要 " + result + "天");
//
//        result = getREE(25, new BigDecimal("80"), true);
//        System.out.println("80kg 25岁男性 行为代谢0.4 每天的基础代谢为 " + result + "Kcal");
//
//        result = getBaseNeedKcal(new BigDecimal("0.4"), new BigDecimal("80"), true, 25);
//        System.out.println("80kg 25岁男性 行为代谢0.4 每天的代谢为 " + result + "Kcal");
//
//        result = getProtein(new BigDecimal("80"), SPORT_TYPE_LOSS_FAT);
//        System.out.println("建议每天摄入蛋白质 " + result + "g");
//
//        result = getCarbohydrate(new BigDecimal("80"), SPORT_TYPE_LOSS_FAT);
//        System.out.println("建议每天摄入碳水 " + result + "g");
//
//        BigDecimal needProteinKacl = getProtein(new BigDecimal("80"), SPORT_TYPE_LOSS_FAT).multiply(new BigDecimal("4"));
//        BigDecimal needCarbohydrateKacl = getCarbohydrate(new BigDecimal("80"), SPORT_TYPE_LOSS_FAT).multiply(new BigDecimal("4"));
//        //总需摄入
//        BigDecimal allInKacl = needProteinKacl.add(needCarbohydrateKacl);
//        System.out.println("总热量 " + allInKacl + "Kcal");
//
//        System.out.println("维持");
//        System.out.println();
//        result = getProtein(new BigDecimal("80"), SPORT_TYPE_KEEP);
//        System.out.println("建议每天摄入蛋白质 " + result + "g");
//
//        result = getCarbohydrate(new BigDecimal("80"), SPORT_TYPE_KEEP);
//        System.out.println("建议每天摄入碳水 " + result + "g");
//
//        needProteinKacl = getProtein(new BigDecimal("80"), SPORT_TYPE_KEEP).multiply(new BigDecimal("4"));
//        needCarbohydrateKacl = getCarbohydrate(new BigDecimal("80"), SPORT_TYPE_KEEP).multiply(new BigDecimal("4"));
//        //总需摄入
//        allInKacl = needProteinKacl.add(needCarbohydrateKacl);
//        System.out.println("总热量 " + allInKacl + "Kcal");
//
//        System.out.println("增肌");
//        System.out.println();
//        result = getProtein(new BigDecimal("80"), SPORT_TYPE_GAIN_MUSCLE);
//        System.out.println("建议每天摄入蛋白质 " + result + "g");
//
//        result = getCarbohydrate(new BigDecimal("80"), SPORT_TYPE_GAIN_MUSCLE);
//        System.out.println("建议每天摄入碳水 " + result + "g");
//
//        needProteinKacl = getProtein(new BigDecimal("80"), SPORT_TYPE_GAIN_MUSCLE).multiply(new BigDecimal("4"));
//        needCarbohydrateKacl = getCarbohydrate(new BigDecimal("80"), SPORT_TYPE_GAIN_MUSCLE).multiply(new BigDecimal("4"));
//        //总需摄入
//        allInKacl = needProteinKacl.add(needCarbohydrateKacl);
//        System.out.println("总热量 " + allInKacl + "Kcal");
    }
}

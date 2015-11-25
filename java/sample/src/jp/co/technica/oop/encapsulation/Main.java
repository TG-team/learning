package jp.co.technica.oop.encapsulation;

import jp.co.technica.oop.encapsulation.sort.SortManager;
import jp.co.technica.oop.encapsulation.sort.Sorter;
import jp.co.technica.oop.encapsulation.sort.Type;

public class Main {

	public static void main(String[] args) {
		sort(Type.BUBBLE);
		sort(Type.SHELL);
		sort(Type.QUICK);
	}

	private static void sort(Type sortType) {
		long time = System.currentTimeMillis();

		Sorter sorter = SortManager.creater(sortType);
		sorter.sort(DATA.clone());

		System.out.println(sortType.name() + " : " + (System.currentTimeMillis() - time));
	}

	private static final int[] DATA = { 4248, 844, 4026, 3396, 390, 2767, 1742, 2696, 3169, 3066, 4108, 574, 823, 2555,
			3482, 114, 1956, 2838, 1966, 437, 1492, 4887, 542, 2101, 3412, 2765, 454, 74, 1864, 3942, 3364, 1479, 2949,
			1654, 4409, 1694, 765, 1161, 3604, 811, 1092, 3729, 3315, 2291, 4890, 3076, 3508, 4332, 3385, 2536, 4143,
			3115, 3075, 846, 3545, 4883, 307, 1981, 865, 2777, 1726, 1709, 4507, 3470, 4388, 2317, 4574, 4165, 2878,
			1713, 683, 2593, 1925, 2825, 2766, 3870, 54, 1250, 1345, 2161, 4664, 1128, 1928, 4985, 48, 3784, 1566, 963,
			2554, 1924, 557, 2321, 463, 3525, 3345, 4441, 3974, 3096, 499, 3745, 2527, 2147, 2831, 3533, 4549, 4265,
			2024, 216, 3049, 4017, 203, 4837, 4084, 22, 2100, 3797, 3546, 1380, 3022, 86, 2862, 1255, 1245, 3843, 1986,
			2015, 1758, 2954, 2864, 4794, 3349, 2085, 722, 4049, 470, 3945, 1179, 2234, 1952, 4961, 2809, 262, 1938,
			1096, 561, 3692, 475, 2426, 142, 2829, 2758, 3100, 2521, 2409, 2452, 851, 2388, 3786, 1544, 1821, 3271,
			3196, 2993, 891, 372, 2653, 473, 1416, 1426, 1708, 1612, 2807, 3617, 3633, 4471, 2068, 4971, 4805, 2483,
			2035, 2843, 1075, 555, 40, 1827, 4899, 1473, 3214, 3489, 1651, 20, 3237, 2558, 3367, 2654, 2231, 1434, 3992,
			828, 3397, 1424, 1087, 2985, 2535, 3793, 2203, 3788, 1527, 3499, 530, 1730, 1407, 2857, 1882, 3170, 28,
			4151, 4350, 1644, 3058, 2044, 3731, 775, 309, 2181, 3819, 4094, 2576, 1401, 2197, 4500, 3615, 1876, 2901,
			1551, 2191, 4178, 4587, 4568, 1188, 4680, 3989, 3872, 1704, 3497, 4923, 3966, 4116, 4800, 3221, 2692, 2262,
			11, 4557, 4353, 900, 4238, 1835, 1912, 2086, 1892, 3881, 3802, 3044, 2314, 2369, 4101, 2003, 1114, 1398,
			4383, 3973, 1861, 3679, 4044, 286, 2463, 4988, 933, 267, 1377, 1234, 3787, 3027, 4902, 2455, 178, 539, 431,
			4799, 4025, 2950, 2440, 4950, 3164, 3559, 3581, 3149, 2449, 3476, 704, 4731, 2863, 3588, 4, 3404, 2187, 208,
			941, 3826, 4798, 3582, 1773, 4091, 2853, 4659, 3517, 604, 4930, 3142, 3130, 1776, 2827, 2046, 4941, 443,
			1877, 4653, 106, 3840, 490, 1154, 3408, 3140, 1039, 1311, 2642, 4021, 2090, 2951, 4999, 4815, 2866, 1153,
			671, 4641, 238, 4068, 511, 164, 337, 4940, 4694, 4819, 1954, 1592, 1200, 1744, 3921, 2233, 3195, 4410, 1941,
			2590, 2682, 2876, 533, 4150, 1741, 1177, 3496, 4134, 967, 1166, 4439, 3087, 2383, 3494, 1026, 2042, 1240,
			1053, 4683, 3752, 3609, 3133, 306, 4352, 659, 2292, 1641, 1136, 65, 1847, 549, 4718, 3857, 2185, 2548, 2987,
			3274, 1798, 4053, 112, 899, 4806, 4400, 3798, 257, 538, 2795, 3665, 2360, 2280, 1149, 4444, 2990, 3544,
			1873, 1665, 840, 3632, 4881, 2632, 3230, 2194, 4120, 2531, 514, 3982, 3422, 4497, 279, 234, 1369, 72, 1530,
			3319, 4898, 3085, 2145, 3601, 2060, 1256, 1276, 4624, 2103, 3464, 179, 3407, 1003, 4032, 3015, 3730, 863,
			931, 2600, 2786, 4276, 2149, 3071, 3168, 990, 2205, 392, 1462, 2108, 2916, 2079, 2265, 1175, 1353, 138,
			1485, 4343, 411, 412, 3430, 3094, 917, 432, 4329, 3166, 4570, 3697, 525, 2320, 4023, 1357, 2905, 3339, 1728,
			3200, 2889, 113, 708, 69, 3199, 1072, 4648, 4359, 3025, 3208, 1452, 2389, 2723, 2159, 4736, 4220, 2303,
			2881, 1420, 2693, 535, 3512, 4964, 2157, 4224, 1883, 4323, 2098, 4714, 335, 4090, 2316, 4363, 3763, 1366,
			2537, 489, 4223, 2730, 1562, 615, 1142, 654, 1541, 1832, 4268, 1395, 2047, 4203, 3189, 4269, 2648, 4480,
			2966, 1118, 1213, 1984, 3557, 702, 1, 1880, 2968, 1501, 1799, 607, 481, 3111, 4351, 705, 4629, 4758, 4459,
			2883, 171, 2842, 23, 2824, 1691, 1833, 2630, 3002, 137, 1525, 1252, 2107, 2547, 3425, 2486, 239, 166, 3574,
			2190, 1327, 446, 3960, 3138, 3648, 3120, 2615, 1617, 3365, 4842, 3531, 667, 4438, 2972, 569, 812, 180, 4845,
			1810, 3438, 3600, 2367, 951, 1195, 1707, 1038, 4642, 3627, 868, 4241, 4454, 4207, 2362, 1836, 123, 1962,
			4792, 1460, 1631, 1454, 4176, 3488, 845, 1290, 3667, 770, 4582, 3131, 1016, 1585, 3782, 818, 1089, 1677,
			2783, 674, 913, 190, 1834, 4301, 1242, 3298, 732, 4973, 160, 3210, 272, 4823, 3685, 703, 1458, 3635, 3145,
			4136, 3606, 3228, 2282, 3039, 783, 150, 4333, 1403, 2953, 2562, 3760, 2882, 4521, 1813, 1820, 4279, 3932,
			3893, 4743, 3853, 800, 3854, 1591, 1819, 3659, 2691, 2309, 3724, 3610, 2273, 1457, 2408, 1120, 366, 3392,
			4460, 2162, 3734, 546, 3961, 1029, 1429, 3224, 4167, 4345, 1461, 2551, 3568, 2428, 4874, 4772, 3611, 4478,
			370, 3746, 4230, 2136, 4428, 2768, 3443, 3628, 1557, 4738, 4240, 2793, 3036, 3410, 4179, 4698, 3487, 4016,
			966, 1510, 2526, 415, 4601, 1062, 4288, 4435, 428, 4677, 4934, 2482, 3972, 2884, 4563, 632, 236, 901, 947,
			1225, 3539, 2524, 3474, 3706, 3419, 2561, 2780, 2155, 2640, 768, 4208, 1456, 4606, 1374, 2172, 2890, 1905,
			4432, 153, 3081, 932, 4968, 2607, 1438, 4997, 3625, 4412, 2326, 464, 1303, 249, 2485, 3723, 3330, 3373,
			3483, 1601, 348, 510, 4775, 4421, 4055, 2051, 263, 4643, 1629, 1172, 2065, 495, 417, 2761, 1383, 3194, 4576,
			3563, 4965, 2423, 1083, 4324, 4098, 1411, 564, 174, 2130, 1686, 4110, 4978, 156, 1712, 1368, 1752, 1066,
			3278, 3703, 3848, 939, 3928, 4088, 3565, 184, 3753, 1185, 2894, 351, 2727, 1292, 558, 1987, 1628, 407, 2565,
			3513, 1871, 1237, 4531, 2266, 4537, 2208, 241, 641, 2539, 544, 1860, 4900, 3809, 2307, 3801, 2030, 303,
			4920, 3255, 1830, 4495, 1435, 93, 4539, 2381, 1632, 2230, 2023, 2025, 3211, 1132, 2874, 271, 1953, 4880,
			2569, 2431, 517, 2900, 980, 2299, 2402, 949, 1258, 3436, 669, 84, 1108, 3309, 3486, 906, 2806, 4022, 2341,
			4610, 2480, 1980, 4684, 3699, 1895, 898, 2499, 393, 1339, 1333, 1897, 4649, 4763, 4147, 3052, 1351, 1157,
			201, 42, 2617, 1761, 1487, 706, 4955, 1291, 4236, 3878, 1502, 1974, 661, 2397, 4263, 2743, 2614, 2070, 3241,
			2472, 159, 4193, 1348, 996, 1589, 869, 61, 4394, 2184, 1575, 204, 4014, 193, 4229, 4959, 1815, 4498, 1514,
			1868, 1789, 486, 265, 1078, 3429, 3975, 2994, 1803, 1263, 3594, 2018, 2975, 299, 2733, 77, 1543, 716, 1812,
			3495, 2277, 3791, 2835, 4141, 968, 2111, 2179, 3065, 80, 1680, 2213, 96, 4411, 2662, 2603, 3202, 3858, 3437,
			2498, 875, 3689, 1319, 2656, 738, 1613, 487, 1619, 2552, 613, 3551, 3944, 1006, 4180, 1878, 2914, 4623,
			4117, 506, 353, 2263, 1162, 4561, 3300, 3759, 1854, 3613, 763, 673, 2778, 1993, 1970, 4889, 3593, 4816,
			4850, 2746, 292, 3805, 3042, 4060, 1647, 678, 4708, 1671, 98, 575, 2511, 3967, 2358, 64, 1874, 2330, 2371,
			3950, 728, 56, 2530, 3849, 2224, 1919, 4209, 2110, 2943, 1262, 681, 4336, 4447, 3280, 1464, 4972, 1907, 680,
			1896, 822, 445, 3366, 1931, 2343, 1476, 1692, 2962, 181, 198, 3935, 223, 2880, 2250, 1840, 4644, 3471, 4468,
			1022, 3472, 2143, 2683, 1451, 4751, 4879, 1766, 3518, 403, 3958, 874, 1074, 1509, 4284, 2430, 2608, 38, 670,
			2643, 4783, 1269, 1067, 1365, 1872, 2533, 3261, 3452, 4124, 1724, 2300, 773, 5000, 2285, 694, 2387, 1837,
			107, 1513, 1272, 2050, 2550, 3205, 1156, 3773, 4250, 3177, 3823, 1105, 3691, 189, 1109, 3327, 4856, 2706,
			3737, 582, 4302, 760, 4041, 1894, 4425, 2869, 4202, 1716, 3320, 3335, 2131, 1301, 801, 4515, 1340, 3605,
			331, 4163, 1122, 3178, 4926, 959, 3698, 1574, 2920, 3514, 3985, 1914, 4217, 108, 2695, 3566, 1405, 2357,
			2738, 4372, 2859, 2661, 1331, 357, 2971, 3268, 1863, 2753, 4419, 2578, 3050, 2298, 2011, 624, 2088, 1176,
			1915, 2171, 315, 1674, 416, 749, 1796, 4877, 1466, 3994, 2991, 3342, 1639, 4921, 3619, 2801, 1393, 3033,
			1362, 1378, 3707, 3215, 608, 1328, 3449, 2854, 1091, 1126, 3124, 2982, 581, 3117, 413, 3855, 2462, 1028,
			3204, 191, 4083, 2756, 1322, 4443, 128, 4987, 1951, 3882, 2400, 3247, 3833, 4735, 400, 695, 46, 256, 4077,
			4695, 2396, 4761, 665, 2373, 3876, 623, 4762, 4063, 2568, 4434, 227, 3035, 127, 1659, 4182, 3032, 2104,
			3681, 3391, 583, 4340, 4760, 619, 628, 3326, 3777, 1332, 3034, 4464, 1025, 1538, 1148, 1656, 4640, 943, 361,
			2251, 200, 4418, 332, 462, 3440, 2328, 1391, 928, 9, 4615, 4212, 4896, 126, 3548, 4617, 4824, 186, 656,
			2114, 2276, 4936, 3956, 3595, 955, 1511, 2301, 816, 1422, 4381, 2272, 1884, 867, 2437, 165, 3655, 2404,
			4765, 360, 4924, 1655, 4776, 2846, 2456, 1494, 601, 4590, 4579, 2856, 3862, 850, 4466, 1635, 4245, 3439,
			2740, 224, 2013, 3925, 2269, 4100, 3249, 4201, 70, 1004, 727, 4010, 1935, 1695, 1073, 4948, 2500, 1097,
			2473, 2087, 396, 3028, 1103, 3552, 2984, 1218, 1715, 2059, 1669, 4132, 4259, 2932, 4976, 3547, 2347, 373,
			3106, 3920, 3537, 2334, 3728, 4966, 2359, 4437, 3251, 3031, 498, 2906, 1209, 4183, 2173, 718, 2492, 2610,
			1521, 3350, 3741, 4820, 4192, 936, 2732, 1419, 3097, 4700, 4325, 301, 1529, 3640, 2591, 1199, 2775, 2646,
			3113, 3860, 1384, 4909, 1893, 4608, 4727, 1593, 776, 491, 3101, 4216, 1721, 1277, 364, 253, 1220, 3755,
			3252, 2112, 3114, 408, 3030, 3116, 1302, 3637, 573, 3758, 4534, 4335, 359, 2867, 4690, 161, 724, 4097, 447,
			1146, 1978, 593, 698, 2759, 3203, 2671, 283, 3887, 2245, 1107, 1512, 3630, 3616, 435, 2223, 4520, 3946, 735,
			1569, 3175, 2674, 1702, 3938, 4867, 2979, 4581, 1994, 2238, 2488, 4589, 2773, 1390, 4745, 3696, 1532, 2364,
			4395, 1676, 1125, 4402, 3220, 4647, 3418, 167, 4769, 1421, 4392, 1354, 1241, 4285, 4489, 988, 4533, 3775,
			4855, 3257, 4430, 229, 3109, 2206, 4818, 4346, 3037, 4722, 433, 1563, 4984, 2553, 4612, 4597, 4121, 1824,
			4298, 4786, 1397, 4836, 2989, 1045, 4309, 2618, 719, 1901, 4927, 294, 2744, 4876, 2236, 1230, 987, 3192,
			320, 2948, 1507, 3134, 4565, 2351, 2442, 4290, 4556, 2214, 4504, 3701, 4452, 2243, 4327, 532, 3064, 1104,
			68, 2002, 1271, 4884, 855, 2627, 4319, 787, 1898, 3904, 1646, 1343, 3378, 4069, 1495, 4702, 3400, 3451,
			1335, 1113, 468, 97, 139, 2312, 2102, 1181, 3038, 102, 756, 4357, 3388, 3623, 1160, 2503, 1173, 1130, 1736,
			4603, 4107, 848, 4852, 810, 3520, 259, 4785, 2676, 1982, 4133, 4993, 4633, 715, 3940, 3239, 214, 2721, 1664,
			35, 4907, 1098, 4396, 4255, 4477, 4658, 919, 4904, 2812, 3812, 809, 2215, 784, 4604, 1110, 2394, 1814, 2540,
			2592, 548, 3475, 3083, 3226, 1133, 339, 3838, 4181, 124, 1683, 4530, 4502, 4135, 4177, 1857, 485, 1870,
			1090, 935, 965, 3067, 1141, 1570, 1204, 1490, 4536, 4000, 4508, 3102, 1336, 2546, 4246, 3258, 2063, 2871,
			2861, 395, 2346, 2739, 1057, 1412, 3161, 1483, 4043, 2429, 3986, 4087, 2056, 4420, 3550, 4638, 4119, 2957,
			2124, 2182, 3569, 3156, 4944, 502, 814, 766, 3589, 32, 4386, 3294, 4126, 3587, 1740, 3663, 2967, 918, 536,
			2969, 1775, 3281, 2986, 3382, 4004, 4863, 2345, 4382, 4635, 1886, 3599, 44, 4830, 1326, 2626, 1287, 2983,
			2256, 4757, 1571, 903, 2999, 2961, 4349, 310, 1554, 1517, 2840, 3493, 2271, 2422, 1014, 3447, 1081, 4834,
			1183, 1178, 2725, 2219, 2505, 382, 4739, 1259, 2391, 4012, 4756, 2229, 4753, 897, 3445, 4605, 1306, 3863,
			2938, 4546, 4848, 4104, 2366, 3390, 3748, 4545, 2126, 4710, 1825, 213, 4969, 588, 813, 1481, 4696, 3766,
			2296, 4347, 3626, 4552, 2624, 2354, 2944, 244, 4072, 4901, 4981, 729, 4028, 2502, 3148, 2517, 4709, 4244,
			4618, 4784, 4512, 3711, 1281, 3631, 3112, 2134, 3340, 4391, 2445, 572, 4908, 1735, 4982, 2623, 1145, 305,
			3603, 2687, 3374, 4374, 2595, 3405, 1232, 2183, 3450, 2248, 2053, 3769, 1201, 524, 2027, 2120, 3186, 526,
			2670, 3828, 2922, 2813, 4858, 1902, 4995, 889, 4033, 3151, 1480, 3957, 1496, 4916, 1969, 541, 1019, 688,
			989, 1341, 4047, 2635, 2302, 3947, 4584, 334, 3641, 341, 3403, 711, 1723, 4470, 1249, 1841, 1747, 4365,
			2386, 4918, 4586, 4951, 2633, 4895, 1957, 4486, 3292, 778, 2925, 2487, 465, 2522, 3821, 3570, 342, 369, 896,
			4917, 4732, 1408, 1288, 2913, 1722, 1140, 2212, 3924, 1463, 736, 2604, 3086, 4251, 1093, 2419, 4851, 1739,
			3277, 1024, 1147, 4103, 3645, 2252, 1020, 2868, 2258, 4510, 3465, 1196, 1305, 3183, 2382, 2133, 2939, 691,
			1564, 3575, 2742, 4580, 4795, 2788, 3338, 1347, 2342, 1012, 2204, 3270, 3217, 2235, 3234, 2069, 2663, 920,
			2709, 3191, 2822, 2504, 157, 3492, 1023, 3978, 2609, 4516, 1685, 4422, 634, 3250, 1755, 1849, 55, 1668,
			4086, 1603, 2945, 4475, 2091, 3621, 576, 944, 4892, 1690, 568, 1208, 4221, 3355, 4082, 1329, 398, 3012,
			4752, 1658, 4873, 421, 4669, 4711, 4375, 4092, 4814, 4426, 1274, 4293, 629, 4558, 194, 397, 2700, 434, 2218,
			4137, 3670, 255, 4157, 2821, 1184, 543, 3159, 3686, 404, 3852, 2411, 3020, 4912, 1440, 2712, 2454, 4726,
			3265, 771, 3011, 2476, 2372, 741, 1070, 873, 2508, 3558, 1979, 3380, 1321, 2586, 3491, 2158, 723, 2719,
			4472, 3099, 4416, 1667, 4197, 4963, 4413, 291, 3288, 1780, 245, 1717, 3070, 4297, 3837, 841, 2474, 1325,
			346, 3768, 4571, 3137, 1828, 4499, 4817, 478, 521, 2198, 795, 4046, 639, 2260, 476, 2491, 1976, 4034, 2955,
			1579, 2946, 2012, 4535, 1947, 1926, 282, 3962, 4287, 246, 460, 4929, 692, 2241, 2625, 4870, 1733, 1621,
			3743, 1248, 4320, 1524, 4118, 3254, 16, 4566, 3654, 26, 3576, 1973, 1756, 617, 4687, 1293, 104, 4303, 994,
			4547, 2403, 3660, 547, 1275, 205, 3416, 3750, 111, 2289, 2393, 19, 978, 743, 4214, 219, 4451, 0, 1795, 2439,
			638, 4079, 751, 4050, 4882, 3377, 1251, 4666, 4075, 3561, 1138, 2781, 2495, 172, 737, 273, 4145, 4282, 979,
			2528, 1163, 129, 3295, 964, 1933, 734, 614, 781, 3235, 2899, 2237, 3128, 2790, 2529, 1056, 4378, 940, 1826,
			3264, 4304, 2226, 2760, 3307, 1465, 3792, 2515, 4115, 503, 1762, 551, 3919, 4278, 3401, 4442, 1596, 401,
			302, 1620, 4525, 3141, 4755, 4656, 326, 3678, 3894, 2858, 907, 3813, 2166, 2647, 4803, 2897, 4399, 1371,
			2974, 3444, 2078, 2139, 1879, 377, 1599, 2910, 2201, 4080, 3059, 2221, 2077, 1323, 505, 1134, 3227, 877,
			4674, 3139, 1475, 2410, 1519, 2196, 1520, 4541, 500, 467, 2791, 2772, 1672, 2606, 1453, 4548, 4078, 3714,
			329, 4440, 4254, 47, 1316, 731, 910, 974, 972, 474, 92, 4595, 914, 2014, 1943, 1586, 295, 52, 2425, 3198,
			981, 3963, 585, 4369, 430, 59, 4096, 596, 1875, 791, 4614, 3304, 3661, 3875, 2168, 1749, 4196, 3774, 3682,
			1678, 1355, 2509, 2770, 3634, 4453, 3467, 3824, 2089, 1102, 1117, 2779, 587, 2960, 2414, 2844, 2436, 4483,
			3080, 3666, 2413, 3356, 1350, 3209, 2363, 420, 2374, 409, 4523, 2659, 1738, 4458, 3804, 1869, 2912, 3540,
			2836, 4646, 222, 1243, 1866, 2493, 183, 4560, 1971, 1788, 2724, 504, 3968, 1417, 354, 3077, 2908, 1988,
			3735, 2904, 2677, 1372, 338, 2507, 2911, 1468, 882, 4153, 3977, 3721, 598, 2080, 3343, 3981, 4342, 423, 922,
			2470, 297, 3286, 3846, 1203, 1318, 4052, 4149, 3054, 31, 1900, 4514, 2350, 2694, 3622, 1771, 50, 2708, 3411,
			419, 2501, 349, 2757, 1285, 2652, 4524, 1131, 757, 4315, 3910, 4922, 2329, 2741, 1399, 3700, 4380, 1041,
			472, 4564, 4673, 399, 3762, 849, 2057, 3690, 1687, 1602, 3866, 1567, 3980, 3807, 4713, 3571, 3995, 4061,
			3883, 3266, 4227, 4009, 4622, 4788, 3336, 4122, 1459, 496, 2156, 1080, 1268, 3368, 3056, 4306, 118, 2146,
			927, 1539, 2378, 243, 226, 1032, 4199, 4651, 4341, 2686, 3704, 266, 95, 4105, 3375, 3290, 3530, 2711, 391,
			2927, 2340, 1506, 1818, 4937, 4632, 3834, 3154, 176, 4749, 1588, 163, 3839, 1478, 3651, 4519, 3147, 4348,
			1239, 1891, 3917, 3053, 1961, 2942, 1929, 3934, 3620, 4599, 484, 479, 1991, 158, 2879, 4910, 950, 2420,
			4366, 937, 3929, 3325, 3434, 3830, 2675, 493, 3865, 3317, 832, 4897, 2058, 1594, 4808, 2669, 2800, 740,
			1150, 764, 4286, 4130, 3181, 235, 4191, 1609, 1095, 3157, 1921, 970, 4308, 3310, 3171, 2655, 2421, 3509,
			4316, 2976, 2434, 1791, 4225, 2325, 2774, 591, 1727, 3927, 4311, 4946, 1224, 3123, 2947, 792, 2293, 992,
			4112, 3757, 3905, 3916, 4949, 4672, 3761, 1447, 1477, 1908, 3316, 3152, 1309, 595, 4857, 1550, 4356, 4321,
			752, 1168, 1413, 2222, 3074, 4029, 2849, 3312, 3143, 2870, 1653, 2433, 2888, 599, 626, 1361, 4551, 2318,
			480, 132, 2896, 67, 679, 785, 4027, 119, 1568, 439, 579, 3383, 4002, 2448, 2567, 371, 1703, 2036, 1640,
			1254, 1034, 4958, 859, 4802, 284, 452, 976, 2958, 1784, 4206, 643, 2305, 3395, 1663, 2152, 2385, 2032, 405,
			1017, 527, 4003, 4741, 83, 3073, 206, 4555, 817, 4861, 3861, 147, 4219, 4729, 1823, 406, 4967, 4175, 1537,
			2261, 1349, 4258, 3888, 3733, 2074, 321, 456, 2169, 880, 1376, 2115, 3964, 4667, 3353, 1493, 2891, 2519,
			794, 207, 1194, 3212, 2720, 362, 1308, 427, 2755, 862, 3341, 2287, 2729, 2665, 3891, 4326, 1508, 1304, 653,
			457, 2611, 658, 2119, 1008, 2937, 531, 2279, 3785, 1094, 1076, 1595, 3332, 3362, 1903, 1505, 3687, 87, 130,
			1129, 819, 3716, 3269, 4660, 1498, 4701, 1472, 3329, 2545, 2715, 4707, 4825, 3536, 82, 2970, 1266, 1648,
			4389, 1189, 1050, 109, 3915, 76, 24, 4109, 4299, 2752, 529, 971, 185, 4006, 2544, 3455, 3190, 2929, 4423,
			1013, 1843, 4864, 3108, 3799, 2216, 755, 1528, 2459, 254, 2376, 1392, 2412, 633, 1264, 140, 1223, 14, 324,
			3289, 2566, 3421, 1899, 3051, 1949, 4429, 290, 1535, 1437, 2009, 3427, 589, 1433, 1606, 2688, 2596, 693,
			4692, 2645, 3930, 105, 4465, 1611, 3352, 1190, 2323, 4275, 3510, 2148, 4331, 3007, 2105, 2636, 2597, 622,
			4005, 1449, 3432, 3193, 3879, 4637, 410, 3999, 2705, 4812, 3093, 700, 3311, 2997, 141, 2848, 1910, 2574,
			1797, 721, 2525, 2324, 664, 3084, 90, 2918, 322, 323, 2520, 4853, 4663, 1745, 1375, 143, 2336, 4270, 580,
			4888, 4074, 2254, 402, 4081, 1522, 1967, 1180, 426, 3969, 4173, 1139, 2819, 4210, 4273, 311, 1622, 2679,
			3669, 4490, 2681, 3694, 2142, 4431, 4184, 798, 453, 2177, 930, 1260, 1338, 2106, 1063, 1071, 1231, 4928,
			957, 1558, 3719, 2940, 1387, 1808, 4457, 1675, 376, 2601, 4020, 1443, 3712, 605, 1046, 4979, 1356, 2802,
			3629, 13, 3897, 100, 4744, 4747, 3647, 4295, 1960, 2965, 1367, 4767, 2808, 2804, 2048, 1650, 744, 4914,
			3818, 3808, 221, 3890, 131, 4152, 3162, 3653, 242, 986, 3423, 1936, 2557, 2418, 3532, 2186, 304, 1782, 1119,
			2534, 2444, 631, 425, 2029, 4780, 1785, 270, 1816, 3129, 3406, 4891, 1540, 1214, 1888, 3676, 3359, 3229,
			4198, 2657, 3322, 1634, 4162, 4215, 2297, 2907, 762, 358, 75, 1430, 3110, 378, 3976, 2823, 1937, 1229, 767,
			2794, 3187, 3871, 1964, 769, 1660, 2072, 2873, 4859, 287, 1007, 1484, 3959, 4172, 2619, 4970, 4140, 4793,
			81, 2239, 4233, 4114, 388, 280, 293, 4652, 101, 820, 4160, 1352, 1210, 3420, 4947, 2560, 2379, 3136, 4719,
			3105, 2496, 1934, 2123, 1792, 902, 4262, 4024, 2726, 2973, 2116, 134, 3223, 2638, 2295, 4840, 2097, 2071,
			1205, 4281, 4841, 3764, 779, 4280, 1404, 1206, 1317, 1389, 4064, 960, 4748, 3675, 3306, 1284, 3939, 655,
			120, 3454, 2570, 3770, 3060, 3253, 8, 4479, 3592, 3323, 3993, 686, 2717, 4977, 3314, 1768, 4144, 149, 1804,
			3549, 27, 3135, 1906, 2398, 2061, 1998, 4042, 4598, 1923, 3638, 2432, 2220, 983, 2138, 2041, 4681, 753,
			3831, 1743, 682, 837, 1561, 1542, 2992, 515, 4190, 4518, 1500, 2850, 1052, 2573, 1127, 4289, 3103, 2713,
			4398, 620, 1865, 1920, 4415, 929, 49, 1221, 4125, 3996, 2722, 2782, 3014, 1441, 2384, 1633, 4371, 2352,
			2268, 3098, 220, 3951, 2475, 3516, 3639, 3324, 2895, 618, 3206, 4461, 3578, 2264, 3554, 894, 4407, 4790,
			4913, 1802, 707, 4886, 1382, 2084, 3506, 4670, 2588, 350, 3717, 4070, 2834, 1577, 975, 3771, 2043, 278,
			2076, 4843, 4777, 1049, 1697, 3453, 2714, 3650, 1215, 215, 4496, 3542, 3222, 4417, 1769, 4720, 1444, 4367,
			316, 893, 4232, 1720, 1227, 925, 4650, 4300, 2582, 4703, 1065, 1471, 1106, 3446, 3526, 4234, 2113, 169,
			3911, 4274, 3590, 4001, 2751, 1829, 4123, 4665, 4364, 1174, 4204, 2877, 1171, 2924, 1005, 1235, 1759, 1772,
			1100, 1911, 921, 3127, 2275, 2685, 121, 442, 1560, 594, 4231, 803, 1415, 4878, 2787, 2820, 3528, 3708, 942,
			2471, 276, 471, 2494, 1932, 647, 616, 2270, 1307, 1657, 3602, 2497, 3180, 782, 45, 3184, 835, 797, 240,
			2660, 1581, 3146, 1314, 878, 379, 2658, 3296, 513, 3313, 883, 1734, 187, 394, 281, 4038, 2628, 2735, 2789,
			1217, 3079, 3426, 3238, 790, 1079, 562, 2621, 4730, 4373, 2699, 3800, 3463, 4994, 1662, 2489, 251, 3642,
			2538, 3567, 2247, 247, 1286, 3562, 1169, 4076, 3937, 363, 4205, 911, 1043, 4065, 4939, 4243, 3864, 3776,
			2073, 637, 2745, 89, 1253, 826, 1247, 649, 518, 1867, 4942, 2598, 1381, 2803, 872, 4682, 367, 1515, 3260,
			1996, 720, 2771, 1927, 4619, 3500, 1101, 1737, 3688, 3240, 508, 1334, 4835, 3293, 2716, 4962, 3727, 4424,
			4621, 1470, 3738, 1930, 666, 3104, 3201, 4272, 675, 2996, 1623, 3847, 3279, 4154, 1278, 603, 1313, 4613,
			1608, 3023, 3643, 2805, 2814, 3585, 4724, 4505, 4833, 4187, 3092, 4253, 1088, 1516, 3275, 1992, 1270, 2066,
			881, 3789, 4404, 3216, 799, 3029, 1995, 3013, 289, 387, 609, 2919, 4990, 4854, 3954, 483, 1002, 3521, 1009,
			4170, 2941, 651, 1706, 1312, 3695, 1450, 4543, 4933, 2518, 2335, 288, 1549, 520, 3107, 4089, 4339, 3016,
			696, 726, 1388, 2902, 2885, 556, 1526, 4821, 3469, 3243, 3507, 4450, 4791, 3850, 2784, 3684, 1261, 2933,
			1638, 1082, 635, 1990, 3299, 225, 754, 1386, 4511, 1845, 1887, 864, 3710, 248, 1364, 2167, 2217, 1553, 3041,
			375, 2931, 327, 3725, 2121, 4974, 1427, 2392, 1099, 2464, 611, 2141, 3912, 2225, 4249, 3780, 4960, 296, 993,
			780, 4572, 4008, 218, 3480, 1922, 4492, 1999, 1572, 2127, 2446, 1642, 4113, 274, 2666, 2728, 3889, 3579,
			2718, 4401, 2022, 4686, 2875, 2361, 2754, 3524, 861, 730, 2468, 3018, 3918, 1959, 441, 252, 3413, 91, 2019,
			625, 4156, 4737, 3649, 1711, 3433, 1731, 3457, 2616, 4860, 3783, 2332, 3900, 3158, 4657, 1238, 3481, 4919,
			3441, 4517, 847, 1446, 2200, 3726, 3301, 418, 516, 7, 938, 469, 136, 3318, 4501, 2513, 1055, 2093, 2952,
			1123, 2005, 1627, 2684, 1015, 2747, 4387, 1679, 1862, 1400, 1069, 1777, 3435, 1474, 2010, 3236, 1950, 4678,
			4704, 772, 717, 4954, 2, 566, 701, 2898, 1989, 1587, 3851, 365, 602, 2199, 3095, 3908, 3424, 3781, 4414,
			1607, 2909, 3953, 2151, 1265, 4740, 1698, 4844, 3736, 4260, 802, 1909, 2490, 804, 833, 3519, 571, 277, 3262,
			3231, 1001, 1198, 4159, 3048, 1616, 2964, 2031, 887, 2622, 2082, 4675, 1370, 2959, 4827, 1406, 2313, 3814,
			4522, 948, 3583, 4330, 4728, 1913, 4318, 1684, 2923, 2008, 1760, 2311, 2769, 1233, 1027, 1625, 4847, 1167,
			4257, 2319, 746, 3360, 2703, 2327, 2244, 2259, 2678, 4488, 2978, 909, 4770, 3248, 4925, 2132, 6, 1315, 885,
			2810, 3331, 188, 3026, 4469, 1652, 2140, 1546, 866, 1580, 1030, 330, 2211, 839, 3886, 2028, 4766, 2075, 977,
			3859, 4953, 3484, 4085, 3991, 3263, 4811, 4317, 545, 1890, 807, 3305, 17, 1469, 1373, 3742, 3657, 2125,
			3188, 343, 1324, 4322, 560, 1410, 4975, 699, 3376, 4073, 3182, 4482, 1448, 4797, 1729, 934, 3055, 3003,
			4467, 712, 2253, 250, 4019, 3988, 4596, 1693, 3273, 4831, 170, 4015, 3402, 30, 3121, 789, 2764, 4305, 829,
			4048, 4057, 1031, 3287, 4588, 4368, 1047, 1705, 879, 2322, 3505, 577, 300, 4809, 663, 1061, 3069, 854, 355,
			389, 3903, 1817, 380, 657, 1614, 258, 1583, 4616, 2559, 3553, 195, 2137, 88, 4106, 1576, 1781, 3739, 982,
			565, 308, 3933, 924, 4567, 2368, 1040, 1182, 4826, 344, 1431, 1746, 3845, 1751, 2453, 2928, 1842, 4810,
			3386, 177, 261, 2067, 4384, 4030, 3522, 4493, 3370, 2749, 2930, 2921, 2763, 4989, 336, 4782, 4463, 4448,
			212, 836, 1310, 3543, 1051, 4455, 2988, 3943, 2589, 3591, 2690, 1518, 3898, 2406, 4733, 3459, 4734, 2841,
			2750, 2936, 1948, 3965, 1805, 2435, 3047, 4573, 374, 4804, 3772, 1282, 2798, 1491, 3948, 2466, 58, 559, 275,
			2748, 197, 3970, 4671, 870, 4544, 146, 4764, 2581, 630, 668, 1164, 148, 4337, 2038, 1360, 4408, 3705, 3810,
			3778, 3842, 1044, 1793, 2872, 528, 3172, 3062, 482, 4559, 1794, 1885, 1035, 455, 4689, 3806, 3523, 2037,
			2094, 2998, 3061, 66, 1548, 3683, 2837, 3461, 827, 217, 2667, 340, 2175, 2887, 3815, 2629, 103, 788, 3767,
			4506, 3955, 2081, 4189, 3511, 3803, 2477, 1191, 4906, 3795, 1701, 4185, 2792, 1010, 1858, 2192, 4609, 540,
			831, 4226, 3820, 1337, 36, 3091, 1359, 4188, 592, 4239, 3399, 3233, 4550, 4693, 2672, 154, 85, 4759, 1244,
			3668, 3144, 3303, 3068, 3150, 3740, 4361, 497, 1330, 4569, 2290, 444, 793, 3001, 4607, 2514, 640, 3394,
			2188, 1555, 995, 3478, 2479, 2249, 4630, 1917, 162, 3867, 1997, 3902, 99, 1320, 3167, 4668, 3754, 3379,
			1955, 2380, 4338, 3722, 2288, 3909, 145, 3827, 3825, 1503, 2294, 1077, 78, 2451, 2174, 4313, 1565, 3586,
			2443, 2135, 808, 908, 3952, 4865, 4956, 2564, 1598, 2571, 2613, 684, 3354, 2356, 842, 3608, 1783, 4634,
			3334, 3677, 4578, 523, 2697, 440, 1432, 3941, 3119, 1787, 786, 4296, 1688, 3504, 1770, 3057, 4035, 1965,
			2460, 1719, 384, 3656, 2274, 4054, 2395, 318, 3448, 1904, 4059, 2344, 1630, 2052, 1940, 25, 4829, 3936,
			3259, 3658, 4247, 3267, 3535, 621, 1467, 926, 3720, 1482, 233, 2915, 3914, 4813, 1534, 3006, 2980, 1064,
			4768, 237, 725, 4697, 1228, 1670, 4527, 2785, 1402, 1211, 1732, 2416, 4594, 2240, 1725, 2707, 1618, 4602,
			3462, 2083, 2698, 3153, 1112, 2605, 923, 857, 1135, 4742, 2797, 3398, 4871, 3607, 834, 4456, 1809, 1851,
			2286, 4474, 856, 451, 34, 552, 1790, 4066, 2510, 1186, 4031, 3283, 4626, 2255, 2315, 3817, 1116, 3347, 2839,
			2602, 2160, 3984, 2830, 4583, 4036, 4161, 144, 2447, 3409, 1661, 1590, 494, 3308, 4839, 2062, 714, 733,
			2926, 4639, 210, 2163, 173, 2338, 2631, 3357, 2228, 414, 4503, 3348, 984, 843, 3644, 450, 1165, 2599, 1504,
			3672, 4628, 1115, 2153, 4712, 2680, 4491, 4645, 1151, 3503, 3126, 356, 2349, 39, 3931, 2054, 492, 888, 1068,
			912, 3174, 3718, 1455, 4893, 3090, 1753, 1273, 3498, 37, 2034, 1124, 1425, 2860, 1983, 352, 871, 4307, 645,
			175, 2892, 3276, 904, 2310, 4264, 1379, 2855, 646, 1718, 448, 3361, 2348, 4986, 424, 3473, 3040, 57, 570,
			3922, 952, 3372, 838, 60, 3983, 4849, 3009, 4779, 3502, 4462, 3765, 71, 3987, 4045, 3417, 1800, 317, 4011,
			584, 1289, 1765, 1111, 4801, 1299, 3245, 2650, 4222, 672, 3351, 4067, 590, 312, 4485, 4484, 2284, 4056, 345,
			2049, 122, 4266, 2227, 1918, 4445, 4277, 4186, 182, 3998, 2701, 4390, 4007, 3907, 1036, 1137, 3428, 4095,
			4211, 1681, 3971, 2851, 612, 550, 2847, 2549, 2333, 4532, 853, 4334, 264, 3387, 2817, 610, 3671, 2580, 507,
			3218, 4138, 758, 2637, 3213, 3541, 1298, 3662, 1533, 2956, 3534, 709, 4252, 2796, 1187, 1846, 958, 4577,
			2450, 3896, 1757, 2118, 2506, 3880, 4611, 4261, 29, 4131, 3844, 3646, 4771, 3899, 1216, 3078, 2180, 1086,
			2040, 578, 1059, 1584, 1267, 1850, 3024, 3010, 4591, 21, 3176, 2026, 4750, 553, 1197, 652, 3369, 4146, 4314,
			2541, 4554, 3923, 1958, 3005, 2762, 3160, 2281, 4267, 606, 1778, 3232, 3560, 2641, 4528, 3618, 3155, 650,
			192, 1058, 2612, 4018, 4058, 1559, 1155, 3868, 2339, 4862, 2737, 1666, 466, 4228, 2664, 4362, 2365, 1084,
			3598, 2995, 269, 2195, 2193, 677, 3997, 4526, 4291, 713, 3877, 1975, 3, 4957, 3614, 151, 2164, 2095, 3747,
			422, 2401, 381, 892, 3990, 2575, 1615, 2308, 1750, 4256, 1536, 3122, 998, 4832, 10, 946, 2441, 2828, 4385,
			2734, 4168, 742, 4931, 636, 4354, 2128, 4774, 3045, 3125, 3185, 199, 313, 4174, 1856, 821, 2484, 2257, 2865,
			1763, 2668, 1786, 3021, 537, 2001, 1673, 985, 1295, 3118, 429, 1033, 1855, 4271, 4866, 2045, 3246, 4679,
			3829, 3822, 3088, 2977, 4789, 522, 2516, 211, 2417, 956, 1143, 115, 3527, 1394, 3874, 3779, 2832, 125, 4725,
			449, 2478, 4405, 2481, 519, 4593, 1042, 1158, 1000, 4846, 4194, 739, 3019, 4093, 4869, 4654, 2017, 3652,
			886, 1610, 554, 3584, 1944, 3873, 2399, 1848, 2649, 961, 4242, 3089, 1811, 2457, 1600, 1578, 2845, 2811,
			110, 806, 2886, 3693, 4436, 230, 759, 1499, 4828, 3479, 1853, 2377, 1222, 4773, 1344, 116, 117, 2639, 4051,
			231, 4200, 2064, 2584, 4796, 710, 689, 4397, 2577, 1346, 4945, 2427, 2465, 1699, 4473, 1968, 4310, 4980,
			3836, 2210, 4716, 2283, 62, 4538, 1159, 1202, 761, 2189, 3529, 4915, 4807, 4838, 3371, 4715, 830, 586, 2154,
			2021, 4148, 333, 1682, 368, 4071, 4625, 915, 1764, 2826, 2232, 3442, 4487, 2405, 2981, 567, 3674, 1488,
			4312, 4983, 509, 2799, 3384, 4592, 4195, 3869, 687, 4894, 1192, 3580, 2144, 4427, 3414, 676, 3713, 3673,
			597, 563, 3702, 2304, 4903, 2415, 1531, 1300, 325, 2109, 1801, 1859, 41, 4376, 3564, 1414, 3179, 4099, 1442,
			3197, 2644, 4513, 1048, 2594, 1445, 4868, 3515, 2099, 2000, 953, 3732, 3337, 1754, 2579, 2246, 501, 916,
			1916, 1144, 3207, 4754, 4102, 4631, 4787, 260, 2355, 1710, 2651, 2963, 2917, 135, 4542, 4585, 4627, 202,
			4575, 477, 1839, 1085, 1552, 1212, 2150, 4358, 12, 2563, 2467, 4344, 860, 94, 1985, 1486, 815, 3004, 3835,
			852, 4393, 2004, 4129, 285, 1296, 1939, 4662, 1945, 3597, 4171, 1428, 954, 1283, 600, 4509, 3796, 3664,
			1807, 5, 1604, 314, 1423, 1573, 4235, 3282, 2542, 2903, 1977, 2209, 2935, 3596, 3913, 4166, 876, 2278, 3165,
			3841, 2353, 3501, 4481, 3466, 4449, 4139, 2390, 1409, 3344, 777, 2129, 2092, 3163, 2055, 4370, 2033, 2512,
			3132, 1689, 3577, 1257, 3328, 3381, 1597, 805, 3219, 4872, 1700, 1889, 2016, 328, 196, 63, 4111, 3816, 748,
			4355, 3832, 1121, 4040, 825, 3573, 4562, 2815, 4155, 3008, 1497, 1246, 697, 1624, 1852, 43, 4717, 4688,
			1881, 2006, 155, 3885, 1649, 4328, 2523, 2585, 4705, 1946, 2096, 3468, 2710, 1279, 4169, 1748, 3242, 969,
			991, 1489, 905, 3256, 3756, 3572, 648, 1942, 3460, 2306, 1774, 4905, 3321, 4062, 4213, 2178, 2818, 383,
			3225, 512, 2370, 4142, 4446, 3458, 824, 79, 1822, 53, 4723, 774, 1418, 4691, 660, 3017, 534, 1342, 3063,
			438, 4600, 4039, 2202, 4127, 385, 3043, 4164, 644, 1358, 4721, 3485, 1547, 4885, 3082, 3856, 3538, 3680,
			2242, 4699, 4540, 386, 2702, 2673, 3346, 3556, 459, 4553, 1831, 2620, 3811, 51, 1636, 1436, 3884, 945, 999,
			895, 642, 3072, 1385, 18, 3749, 1018, 3709, 1582, 4283, 3284, 884, 1779, 3244, 168, 1294, 1806, 4685, 2736,
			2170, 298, 3636, 4935, 4676, 3302, 3892, 2816, 1152, 973, 4943, 1170, 1844, 2424, 1626, 4781, 1226, 1060,
			858, 2207, 2458, 4992, 3895, 1236, 4360, 3456, 4655, 347, 1556, 890, 747, 3393, 2833, 4998, 690, 997, 4778,
			1972, 3285, 662, 3297, 796, 1054, 2176, 4529, 4952, 152, 4377, 3477, 1637, 3901, 1363, 627, 4406, 1767, 319,
			1396, 2438, 4706, 2165, 2039, 33, 4661, 4991, 3358, 3431, 4822, 2532, 2543, 4013, 2776, 3949, 1645, 3555,
			4037, 3612, 3751, 3979, 2893, 2020, 4403, 962, 2375, 4218, 3926, 2267, 4294, 4494, 4938, 2007, 4433, 685,
			4996, 268, 73, 3624, 3794, 3490, 4636, 1011, 436, 1545, 4911, 4875, 4158, 1037, 2634, 3363, 1439, 2461,
			1219, 1643, 1714, 2583, 2704, 4379, 2689, 3291, 2587, 1963, 2469, 1838, 3173, 3415, 228, 3000, 1280, 3715,
			4932, 2407, 2731, 1297, 750, 3790, 4476, 4237, 3906, 2122, 3389, 488, 745, 2337, 3333, 1523, 209, 2117,
			4620, 461, 1605, 2934, 2556, 4746, 4128, 458, 4292, 2572, 2852, 232, 1021, 133, 1193, 1207, 3046, 2331,
			1696, 3272, 3744, };
}
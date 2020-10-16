package com.adoph.test.leetcode;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/9/30
 */
public class KingAndGoldTest {
    public static void main(String[] args) {
//        int n = 5;
//        int w = 10;
//        int[] g = {200, 300, 350, 400, 500};
//        int[] p = {3, 3, 4, 5, 5};

        int n = 2;
        int w = 10;
        int[] g = {400, 500};
        int[] p = {5, 5};
        System.out.println(search(n, w, g, p));
        System.out.println(search1(n, w, g, p));

    }

    /**
     * 核心：
     * f(n,w)=0(n=1,w<p[0])
     * f(n,w)=g[0](n=1,w>=p[0])
     * f(n,w)=f(n-1,w)(w<p[n-1])
     * f(n,w)=max(f(n-1,w),f(n-1,w-p[n-1])+g[n-1])
     *
     * @param n 金矿数
     * @param w 工人数
     * @param g 金矿黄金量数组
     * @param p 金矿用工量数组
     */
    public static int search(int n, int w, int[] g, int[] p) {
        if (n == 1) {
            if (w < p[0]) {
                return 0;
            }
            return g[0];
        } else {
            if (w < p[n - 1]) {
                return search(n - 1, w, g, p);
            } else {
                return Math.max(search(n - 1, w, g, p), search(n - 1, w - p[n - 1], g, p) + g[n - 1]);
            }
        }
    }

    public static int search1(int n, int w, int[] g, int[] p) {
        if (n == 1) {
            if (w < p[0]) {
                return 0;
            }
            return g[0];
        } else {
            int[] preRowResults = new int[p.length];
            int[] currRowResults = new int[p.length];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < w; j++) {
                    if (j < p[i]) {
                        currRowResults[j] = preRowResults[j];
                    } else {
                        return Math.max(preRowResults[j], preRowResults[j - p[i]] + g[i]);
                    }
                }
                preRowResults = currRowResults;
            }

            return currRowResults[n];
        }
    }

}

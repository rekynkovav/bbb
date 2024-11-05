package ru.suveren.life;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Logika {
    static final byte POLE = 100;
    private static final double procentGenereitLive = POLE * 15;
    private static byte lifeCount = 0;

    private static byte ObxodSosedi(JPanel[][] mas, int ii, int jj) {
        for (int i = ii; i < mas.length; i++) {
            for (int j = jj; j < mas[i].length; j++) {
                // верхняя граница горизонт
                if (i == 0 && j > 0 && j < mas[i].length - 2) {
                    if (mas[i][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }

                // верхний правый угол
                if (i == 0 && j == mas.length - 1) {
                    if (mas[0][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[1][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[0][j].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }

                // правая граница вертикаль
                if (i > 0 && j == mas.length - 1 && i <= mas.length - 2) {
                    if (mas[i - 1][mas.length - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][mas.length - 2].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i][mas.length - 2].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][mas.length - 2].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][mas.length - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }

                // правый нижний угол
                if (i == mas.length - 1 && j == mas.length - 1) {
                    if (mas[i][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }

                // нижний горизонт
                if (i == mas.length - 1 && j > 0 && j <= mas.length - 2) {
                    if (mas[i][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }
                // нижний левый угол
                if (i == mas.length - 1 && j == 0) {
                    if (mas[i - 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }

                //левая стенка вертикаль
                if (i > 0 && j == 0 && i <= mas.length - 2) {
                    if (mas[i - 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }
                //поле на 8 соседей
                if (i > 0 && j > 0 && i <= mas.length - 2 && j <= mas.length - 2) {
                    if (mas[i - 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i - 1][j - 1].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }
                // верхний левый угол
                if (i == 0 && j == 0) {
                    if (mas[i][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j].isVisible() == true) {
                        lifeCount++;
                    }
                    if (mas[i + 1][j + 1].isVisible() == true) {
                        lifeCount++;
                    }
                    return lifeCount;
                }
            }
        }
        return lifeCount;
    }

    static JPanel[][] genereitLive(JPanel[][] mas) {
        for (int i = 0; i < (int) procentGenereitLive; i++) {

            int random = (int) (Math.random() * POLE);
            int random2 = (int) (Math.random() * POLE);
            mas[random][random2].setVisible(true);

        }
        return mas;
    }

    static void liveRun(JPanel[][] jPanelMassive) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < jPanelMassive.length; i++) {
                    for (int j = 0; j < jPanelMassive[i].length; j++) {
                        Logika.ObxodSosedi(jPanelMassive, i, j);
                        if (jPanelMassive[i][j].isVisible() == false && lifeCount == 3) {
                            jPanelMassive[i][j].setVisible(true);
                        }
                        if (jPanelMassive[i][j].isVisible() == true && lifeCount == 2 || lifeCount == 3) {
                            jPanelMassive[i][j].setVisible(true);
                        } else {
                            jPanelMassive[i][j].setVisible(false);
                        }
                        lifeCount = 0;
                    }
                }
            }
        });
    }



    static void goo() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                Logika.liveRun(Freim.jPanelMassive);
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}

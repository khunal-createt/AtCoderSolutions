package com.atCoder.bedinnerContest.contest371;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class Jiro {

    public Character middleBrother(List<Character> relation) {

        Character S_AB = relation.get(0);
        Character S_AC = relation.get(1);
        Character S_BC = relation.get(2);
        // 比較関係に基づいて年齢順を決定
        if (S_AB.equals('>') && S_AC.equals('>')) {
            // Aが最年長
            if (S_BC.equals('>')) {
                return 'B'; // C < B < A
            } else {
                return 'C'; // B < C < A
            }
        } else if (S_AB.equals('<') && S_AC.equals('<')) {
            // Aが最年少
            if (S_BC.equals('>')) {
                return 'C'; // A < C < B
            } else {
                return 'B'; // A < B < C
            }
        } else if (S_AB.equals('>') && S_AC.equals('<')) {
            // Bが最年少
            return 'A'; // B < A < C
        } else if (S_AB.equals('<') && S_AC.equals('>')) {
            // Cが最年少
            return 'A'; // C < A < B
        }
        return null;
    }

}
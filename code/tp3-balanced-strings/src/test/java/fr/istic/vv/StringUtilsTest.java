package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    StringUtils str;

    @BeforeEach
    void init(){
        str = new StringUtils();
    }

    @Test
    @DisplayName("Test sur les crochets, parenthèses et accolades")
    void testCrochetNotBalanced(){
        String strUnCrochet = "[";
        String strUneParenthèse = "(";
        String strUneAccolade = "{";
        assertFalse(isBalanced(strUnCrochet), "un crochet");
        assertFalse(isBalanced(strUneParenthèse), "une parenthèse");
        assertFalse(isBalanced(strUneAccolade), "une accolade");
    }

    @Test
    @DisplayName("Sans symboles")
    void testSansSymboles(){
        String strSansSymboles = "sans symbole";
        assertTrue(isBalanced(strSansSymboles));
    }

    @Test
    @DisplayName("Avec Crochet")
    void testAvecCrochet(){
        String strAvecCrochet = "[]";
        assertTrue(isBalanced(strAvecCrochet), "avecCrochet");
    }

    @Test
    @DisplayName("Avec Parenthèse")
    void testAvecParenthese(){
        String strAvecParenthese = "()";
        assertTrue(isBalanced(strAvecParenthese), "avecParenthese");
    }

    @Test
    @DisplayName("Avec Accolade")
    void testAvecAccolade(){
        String strAvecAccolade = "{}";
        assertTrue(isBalanced(strAvecAccolade), "avecAccolade");
    }

    @Test
    @DisplayName("Avec tous les symboles not balanced")
    void testAvecTousLesSymbolesNotBalanced(){
        String strTousLesSymbolesNotBalanced = "{ ] ] ( { )) ]]] }";
        assertFalse(isBalanced(strTousLesSymbolesNotBalanced),
                "tous les symboles not balanced");
    }

    @Test
    @DisplayName("Avec tous les symboles isBalanced")
    void testAvecTousLesSymbolesBalanced(){
        String strTousLesSymbolesBalanced = "{ ( [ } ] )";
        String strTousLesSymbolesBalanced2 = "{[][]}({})";
        assertTrue(isBalanced(strTousLesSymbolesBalanced), "tous les symboles");
        assertTrue(isBalanced(strTousLesSymbolesBalanced2), "tous les symboles");
    }
}
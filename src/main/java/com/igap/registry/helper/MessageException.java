package com.igap.registry.helper;


/**
 * class MessageException
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
public class MessageException {


    //===============ACCOUNT==================//

    public final static String ACCOUNT_USER_ACCOUNT_IS_REQUIRED = "Les données account sont obligatoire ";
    public final static String ACCOUNT_USER_DETAILS_IS_REQUIRED = "Les données details sont obligatoire ";
    public final static String ACCOUNT_NAME_IS_BUSY = "Le nom utilisateur est déjà utilisé pour un autre compte";
    public final static String ACCOUNT_MAIL_IS_BUSY = "Le mail principale est déjà utilisé pour un autre compte";
    public final static String ACCOUNT_NOT_FOUND = "L'utilisateur n'existe pas";
    public final static String ACCOUNT_SCHOOL_TEACHER_EXIST = "Le prof a déjà un compte dans cet école";
    public final static String NOT_CURRENT_SESSION = "Pas de session en cours";
    public final static String ACCOUNT_PASSWORD_IS_NOT_NULL = "Le password ne peut pas être null";
    public final static String ACCOUNT_PASSWORD_IS_REQUIRED = "Le password est obligatoire";
    public final static String ACCOUNT_USERNAME_IS_REQUIRED = "Le username est obligatoire";
    public final static String ACCOUNT_USERNAME_IS_NOT_NULL = "Le username ne peut pas être null";
    public final static String ACCOUNT_PASSWORD_INCORRECT_IS_REQUIRED = "L'ancien mot de passe est incorrecte";
    public final static String ACCOUNT_MAIL_IS_NOT_NULL = "Le mail ne peut pas être null";
    public final static String MAIL_NOT_VALID = "L'adresse mail est invalide";
    public final static String ACCOUNT_USERNAME_NOT_VALID = "Le nom d'utilisateur doit au moins avoir 4 caractères et ne pas contenir d'espaces";
    public final static String ACCOUNT_PASSWORD_NOT_VALID = "Le mot de passe doit au moins avoir 8 caractères, doit contenir au moins une lettre minuscule, une majuscule, un chiffre et un caractère spécial";


    //===============USER==================//
    public final static String USER_IS_REQUIRED = "L'utilisateur est obligatoire";
    public final static String USER_NOT_FOUND = "L'utilisateur n'existe pas";

    //===============SECURITY==================//
    public static final String PASSWORD_IS_THE_SAME = "le mot de passe est identique, veuillez créer un nouveau mot de passe";
    public static final String TOKEN_INVALID = "le jeton est invalide";
    public static final String TOKEN_EXPIRED = "le jeton est expiré";

    //===============ROLE==================//
    public final static String ROLE_NAME_IS_REQUIRED = "Le nom du role est obligatoire";
    public final static String ROLE_NOT_FOUND = "Le rôle n'existe pas";
    public final static String ROLE_IS_REQUIRED = "Le rôle est obligatoire";
    public final static String ROLE_EXIST = "Ce role existe déjà";
}

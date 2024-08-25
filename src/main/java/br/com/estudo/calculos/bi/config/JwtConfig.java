package br.com.estudo.calculos.bi.config;

import io.jsonwebtoken.SignatureAlgorithm;

public class JwtConfig {

    public static final String SECRET_KEY = "CP1205RM3M1CP1205RM3M1CP1205RM3M1CP1205RM3M1CP1205RM3M1CP1205RM3M1";
    public static final SignatureAlgorithm ALGORITMO_ASSINATURA = SignatureAlgorithm.HS256;
    public static final int HORAS_EXPIRACAO_TOKEN = 1;

}

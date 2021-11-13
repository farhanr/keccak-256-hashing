import static sha.Parameters.KECCAK_256;
import static utils.HexUtils.convertBytesToString;

import sha.Keccak;

import java.nio.charset.StandardCharsets;

public class Main {
  public static void main(String[] args) {
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    String token = "xxx";
    char[] tokenChar = token.toCharArray();
    for (int i = 0; i < alphabet.length; i++) {
      tokenChar[0] = alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        tokenChar[1] = alphabet[j];
        for (int j2 = 0; j2 < alphabet.length; j2++) {
          tokenChar[2] = alphabet[j2];
          getMethodId(tokenChar);
        }
      }
    }

    token = "xxxx";
    tokenChar = token.toCharArray();
    for (int i = 0; i < alphabet.length; i++) {
      tokenChar[0] = alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        tokenChar[1] = alphabet[j];
        for (int j2 = 0; j2 < alphabet.length; j2++) {
          tokenChar[2] = alphabet[j2];
          for (int k = 0; k < alphabet.length; k++) {
            tokenChar[3] = alphabet[k];
            getMethodId(tokenChar);
          }
        }
      }
    }

    token = "xxxxx";
    tokenChar = token.toCharArray();
    for (int i = 0; i < alphabet.length; i++) {
      tokenChar[0] = alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        tokenChar[1] = alphabet[j];
        for (int j2 = 0; j2 < alphabet.length; j2++) {
          tokenChar[2] = alphabet[j2];
          for (int k = 0; k < alphabet.length; k++) {
            tokenChar[3] = alphabet[k];
            for (int k2 = 0; k2 < alphabet.length; k2++) {
              tokenChar[4] = alphabet[k2];
              getMethodId(tokenChar);
            }
          }
        }
      }
    }

    token = "xxxxxx";
    tokenChar = token.toCharArray();
    for (int i = 0; i < alphabet.length; i++) {
      tokenChar[0] = alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        tokenChar[1] = alphabet[j];
        for (int j2 = 0; j2 < alphabet.length; j2++) {
          tokenChar[2] = alphabet[j2];
          for (int k = 0; k < alphabet.length; k++) {
            tokenChar[3] = alphabet[k];
            for (int k2 = 0; k2 < alphabet.length; k2++) {
              tokenChar[4] = alphabet[k2];
              for (int l = 0; l < alphabet.length; l++) {
                tokenChar[5] = alphabet[l];
                getMethodId(tokenChar);
              }
            }
          }
        }
      }
    }

    token = "xxxxxxxx";
    tokenChar = token.toCharArray();
    for (int i = 0; i < alphabet.length; i++) {
      tokenChar[0] = alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        tokenChar[1] = alphabet[j];
        for (int j2 = 0; j2 < alphabet.length; j2++) {
          tokenChar[2] = alphabet[j2];
          for (int k = 0; k < alphabet.length; k++) {
            tokenChar[3] = alphabet[k];
            for (int k2 = 0; k2 < alphabet.length; k2++) {
              tokenChar[4] = alphabet[k2];
              for (int l = 0; l < alphabet.length; l++) {
                tokenChar[5] = alphabet[l];
                for (int l2 = 0; l2 < tokenChar.length; l2++) {
                  tokenChar[6] = alphabet[l2];
                  for (int m = 0; m < tokenChar.length; m++) {
                    tokenChar[7] = alphabet[m];
                    getMethodId(tokenChar);
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  private static void getMethodId(char[] tokenChar) {
    String functions = String.valueOf(tokenChar);
    Keccak keccak = new Keccak();
    String result = "";
    String abc = (functions + "(address,uint256,uint8)").replaceAll("[\\t\\n\\r]+", " ");
    String[] splited = abc.split("\\s+");
    for (int i = 0; i < splited.length; i++) {
      byte[] data = splited[i].getBytes(StandardCharsets.UTF_8);
      String method = "0x" + convertBytesToString(keccak.getHash(data, KECCAK_256)).substring(0, 8);
      result += method;
      result += i == splited.length - 1 ? "" : ",";
    }
    // int same = 0;
    // for (int i = 1; i < result.length(); i++) {
    // if (result.charAt(i)==result.charAt(0)) {
    // same++;
    // }
    // }
    // if(same>=4){
    // System.out.println(result+": "+abc);
    // }
    if (result.contains("abcde") || result.contains("fffff") || result.contains("eeeee") || result.contains("aaaaa") || result.contains("bebeb") || result.contains("01010101") || result.contains("00001111") || result.contains("000000") || result.contains("b00b1e5") || result.contains("1010101") || result.contains("bad455")) {
      System.out.println(result+ ": "+abc);
    }
  }
}
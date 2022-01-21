package br.com.cbgomes.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoRequest {

    private String latitude;
    private String longitude;
}

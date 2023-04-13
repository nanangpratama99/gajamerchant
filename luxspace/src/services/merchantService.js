import http from "../http-common";

class merchantService {
  save(merchantDTO) {
    return http.post("/merchant/save", merchantDTO);
  }
}

export default new merchantService();

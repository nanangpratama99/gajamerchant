import http from "../http-common";

class ownerService {
  save(ownerDTO) {
    return http.post("/owner/save", ownerDTO);
  }

  saveMerchant(merchantsDTO) {
    return http.post("/merchant/save", merchantsDTO);
  }

  GetAll() {
    return http.get("/owner/getAll");
  }

  deleteOwner(id) {
    return http.delete(`/owner/delete/${id}`);
  }

  uploadImage(image, idOwner) {
    let formData = new FormData();
    formData.append("image", image);

    return http.post(`/image/upload/${idOwner}`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
  }
}

export default new ownerService();

import Detai from "./pages/Detail.vue";
import Form from "./pages/Shipping.vue";
import FormMerch from "./pages/Merchant.vue";
import ShippingList from "./pages/ShippingList.vue";
import OwnerList from "./pages/OwnerList.vue";

export default [
  {
    path: "/merchant",
    component: Detai,
  },
  {
    path: "/shipping",
    component: Form,
  },
  {
    path: "/",
    component: FormMerch,
  },
  {
    path: "/shippingList",
    component: ShippingList,
  },
  {
    path: "/ownerList",
    component: OwnerList,
  },
];

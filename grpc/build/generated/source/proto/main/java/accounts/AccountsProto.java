// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: accounts.proto

package accounts;

public final class AccountsProto {
  private AccountsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_accounts_GetAccountByIdRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_accounts_GetAccountByIdRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_accounts_CreateAccountRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_accounts_CreateAccountRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_accounts_AccountResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_accounts_AccountResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016accounts.proto\022\010accounts\"#\n\025GetAccount" +
      "ByIdRequest\022\n\n\002id\030\001 \001(\t\"E\n\024CreateAccount" +
      "Request\022\014\n\004name\030\002 \001(\t\022\020\n\010document\030\003 \001(\t\022" +
      "\r\n\005value\030\004 \001(\001\"L\n\017AccountResponse\022\n\n\002id\030" +
      "\001 \001(\003\022\014\n\004name\030\002 \001(\t\022\020\n\010document\030\003 \001(\t\022\r\n" +
      "\005value\030\004 \001(\0012\250\001\n\010Accounts\022N\n\016getAccountB" +
      "yId\022\037.accounts.GetAccountByIdRequest\032\031.a" +
      "ccounts.AccountResponse\"\000\022L\n\rcreateAccou" +
      "nt\022\036.accounts.CreateAccountRequest\032\031.acc" +
      "ounts.AccountResponse\"\000B\033\n\010accountsB\rAcc" +
      "ountsProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_accounts_GetAccountByIdRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_accounts_GetAccountByIdRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_accounts_GetAccountByIdRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_accounts_CreateAccountRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_accounts_CreateAccountRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_accounts_CreateAccountRequest_descriptor,
        new java.lang.String[] { "Name", "Document", "Value", });
    internal_static_accounts_AccountResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_accounts_AccountResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_accounts_AccountResponse_descriptor,
        new java.lang.String[] { "Id", "Name", "Document", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
